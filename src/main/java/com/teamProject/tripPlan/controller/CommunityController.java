package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.CommentDTO;
import com.teamProject.tripPlan.dto.PlaceDTO;
import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.*;
import com.teamProject.tripPlan.repository.UserRepository;
import com.teamProject.tripPlan.service.*;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    PostService postService;

    @Autowired
    QueryService queryService;

    @Autowired
    UsersService usersService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentService commentService;

    @Autowired
    KeywordService keywordService;

    @Autowired
    MyPageService myPageService;

    @Autowired
    TravelService travelService;

    private static final ThreadLocal<Boolean> deleteInProgress = ThreadLocal.withInitial(() -> false);

    // "localhost:8080:/community" -> community/community.html
    @GetMapping("")
    public String getAllPosts(Model model) {
        List<PostDTO> posts = postService.findAllPost();
        List<Keyword> allKeywords = keywordService.findAllKeywords();
        model.addAttribute("posts", posts);
        model.addAttribute("allKeywords", allKeywords);
        return "community/community"; // 템플릿 이름
    }

    // "localhost:8080:/community" -> community/community.html 의 키워드 필터
    @GetMapping("/filter")
    public String filterPostsByKeywords(@RequestParam(value = "keywords", required = false) Long keywordId, Model model) {
        if (keywordId == null) {
            // 모든 게시글을 반환
            List<PostDTO> allPosts = postService.findAllPost();
            model.addAttribute("posts", allPosts);
        } else {
            List<PostDTO> filteredPosts = postService.findPostsByKeywordId(keywordId);
            model.addAttribute("posts", filteredPosts);
        }
        return "community/community :: postList"; // 부분 업데이트를 위한 fragment 이름
    }

    // "localhost:8080:/new" -> community/newPost.html
    @GetMapping("/new")
    public String newPostForm(Model model, Principal principal, HttpSession session) {
        String userId = principal.getName();
        Long id = myPageService.findUserId(userId);
        UsersDTO dto = myPageService.findLoginUser(id);

        model.addAttribute("person", dto);

        PostDTO postDTO = new PostDTO();
        postDTO.setKeyword(null); // 초기화
        model.addAttribute("dto", postDTO);

        List<MyList> myLists = myPageService.findAllMyLists();
        model.addAttribute("travelLists", myLists);

        // 사용자의 여행 목록을 가져옴
        List<Travel> travels = myPageService.findUserList(id);
        model.addAttribute("list", travels); // 여행 목록 추가

        // 여행 목록이 비어 있으면 리디렉션
        if (travels.isEmpty()) {
            return "redirect:/main"; // /main.html로 리디렉션
        }

        // 각 여행에 대한 장소를 가져옴
        List<Place> places = myPageService.findPlace(id);
        model.addAttribute("places", places); // 여행에 속한 장소 추가

        // 키워드 목록 가져오기
        List<Keyword> allKeywords = keywordService.findAllKeywords();
        model.addAttribute("allKeywords", allKeywords);

        return "community/newPost";
    }

    // "localhost:8080:/new" -> community/newPost.html 의 form action
    @PostMapping("create")
    public String createPost(@ModelAttribute("dto") PostDTO dto, Principal principal, HttpSession session) {
        String userid = principal.getName();
//        queryService.findOneUser(userid);
        Long id = myPageService.findUserId(userid);
        UsersDTO usersDTO = myPageService.findLoginUser(id);

        if (usersDTO == null) {
            return "redirect:/error";
        }

        // UsersDTO를 Users 엔티티로 변환
        Users users = UsersDTO.fromDTO(usersDTO); // UsersDTO를 Users로 변환
        if (users == null) {
            return "redirect:/error"; // 사용자 정보가 없으면 에러 페이지로 리디렉션
        }
        session.setAttribute("userNickname", users.getUserNickname());

        // Travel 정보 설정 (Travel ID가 DTO에 포함된 경우)
        if (dto.getTravel() != null) {
            Travel travel = new Travel();
            travel.setTravelId(dto.getTravel().getTravelId()); // Travel ID 설정
            dto.setTravel(travel); // PostDTO에 Travel 추가
        }

        // PostDTO를 사용해 Post 엔티티로 변환
        Post post = PostDTO.fromDTO(dto);
        post.setUsers(users); // 여기서 users를 설정

        usersService.insertPost(usersDTO.getUserNo(), dto);
//        Long postId = usersService.insertPost(users.getUserNo(), dto);
        return "redirect:/community";
    }

    // "localhost:8080:/{id}" -> community/community.html
    @GetMapping("{id}")
    public String showOnePost(@PathVariable("id") Long id, Model model, Principal principal) {
        PostDTO dto = postService.getOnePost(id);

        // 장소 DTO 리스트 가져오기
        List<PlaceDTO> placeDTOs = travelService.getPlaceDTOsByTravelId(dto.getTravel().getTravelId());
        dto.setPlaces(placeDTOs); // DTO에 장소 리스트 설정

        model.addAttribute("dto", dto);
        model.addAttribute("currentUserId", principal.getName()); // 현재 사용자 ID 추가
        List<CommentDTO> commentDTOS = commentService.findAllComment(id);
        model.addAttribute("comments", commentDTOS);
        postService.calculateLikes(id);
        return "community/showPost";
    }

    @GetMapping("{id}/delete")
    @ResponseBody
    public String deletePost(@PathVariable("id") Long id) {
        System.out.println("Deleting post with ID: " + id);
        postService.deletePost(id);
        return "삭제 성공"; // 삭제 후 모든 게시글 보기 페이지로 리다이렉트
    }

    @GetMapping("{id}/update")
    public String viewUpdatePost(Model model, @PathVariable("id") Long postId) {
        PostDTO postDTO = postService.getOnePost(postId);
        log.info("Updating post: {}", postDTO);

        // Travel 객체가 null인 경우 초기화
        if (postDTO.getTravel() == null) {
            postDTO.setTravel(new Travel());
        }

        model.addAttribute("allKeywords", keywordService.findAllKeywords());
        model.addAttribute("dto", postDTO);
        return "community/updatePost";// updatePost 템플릿으로 이동
    }

    @PostMapping("{id}/update")
    public String updateArticle(@PathVariable("id") Long postId, @ModelAttribute("dto") PostDTO dto) {
        dto.setPostId(postId); // PostDTO에 ID 설정
        postService.updatePost(dto); // 게시물 업데이트
        return "redirect:/community/"+postId; // 업데이트 후 모든 게시글 보기 페이지로 리다이렉트
    }

//    @PostMapping("update")
//    public String updateArticle(PostDTO dto) {
//        postService.updatePost(dto);
//        return "redirect:/community";
//    }

    ///////////////////////////////////// 댓글 처리 //////////////////////////////////////////
    @PostMapping("{id}/comments")
    public String insertComment(CommentDTO dto, @PathVariable("id") Long postId, HttpSession session, Principal principal) {
        Users users = queryService.findOneUser(principal.getName());
        String loggedInNickname = users.getUserNickname();

        if (loggedInNickname != null) {
            dto.setCommentNickname(loggedInNickname);
        } else {
            dto.setCommentNickname("익명");
        }

        // 댓글 추가
        commentService.insertComment(postId, dto, dto.getCommentNickname()); // 닉네임 전달

        return "redirect:/community/" + postId;
    }

    @GetMapping("comments/{id}")
    public String deleteComment(@PathVariable("id") Long commentId) {
        Long postId = commentService.deleteComment(commentId);
        return "redirect:/community/" + postId; // 삭제 후 게시물로 리다이렉트
    }

    @GetMapping("comments/view/{id}")
    public String updateCommentForm(Model model, @PathVariable("id") Long commentId) {
        Map<String, Object> map = commentService.findByCommentId(commentId);
        model.addAttribute("comment", map.get("comment"));
        model.addAttribute("postId", map.get("postId"));
        Long postId = (Long) map.get("postId");
        PostDTO dto = postService.getOnePost(postId);
        model.addAttribute("dto", dto);
        log.info(commentId.toString());
        return "/community/updateComment"; // 댓글 수정 폼으로 이동
    }

    @PostMapping("{postId}/comments/{commentId}")
    public String updateComment(@PathVariable("postId") Long postId,
                                @PathVariable("commentId") Long commentId,
                                CommentDTO dto) {
        dto.setCommentId(commentId);
        commentService.updateComment(dto);
        return "redirect:/community/" + postId; // 수정 후 게시물로 리다이렉트
    }
}