package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.CommentDTO;
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

        List<Keyword> allKeywords = keywordService.findAllKeywords();
        model.addAttribute("allKeywords", allKeywords);

        return "community/newPost";
    }

    // "localhost:8080:/new" -> community/newPost.html 의 form action
    @PostMapping("create")
    public String createPost(@ModelAttribute("dto") PostDTO dto, Principal principal, HttpSession session) {
        String userid = principal.getName();
        Long id = myPageService.findUserId(userid);
        UsersDTO usersDTO = myPageService.findLoginUser(id);

        if (usersDTO == null) {
            return "redirect:/error";
        }

        Users users = new Users();
        users.setUserNo(usersDTO.getUserNo());
        users.setUserId(usersDTO.getUserId());
        users.setUserNickname(usersDTO.getUserNickname());
        session.setAttribute("userNickname", usersDTO.getUserNickname());
        dto.setUsers(users);
//        dto.setPostDate(LocalDateTime.now());
        Long postId = usersService.insertPost(users.getUserNo(), dto);
        return "redirect:/community";
    }

    // "localhost:8080:/{id}" -> community/community.html
    @GetMapping("{id}")
    public String showOnePost(@PathVariable("id") Long id, Model model, Principal principal) {
        PostDTO dto = postService.getOnePost(id);
        model.addAttribute("dto", dto);
        model.addAttribute("currentUserId", principal.getName()); // 현재 사용자 ID 추가
        List<CommentDTO> commentDTOS = commentService.findAllComment(id);
        model.addAttribute("comments", commentDTOS);
        postService.calculateLikes(id);
        return "community/showPost";
    }

    @GetMapping("{id}/delete")
    public String deleteArticle(@PathVariable("id") Long id) {
        postService.deletePost(id);
        return "redirect:/community"; // 삭제 후 모든 게시글 보기 페이지로 리다이렉트
    }

    @GetMapping("{id}/update")
    public String viewUpdateArticle(Model model, @PathVariable("id") Long postId) {
        PostDTO postDTO = postService.getOnePost(postId);
        model.addAttribute("dto", postDTO);
        return "community/updatePost";// updatePost 템플릿으로 이동
    }

    @PostMapping("{id}/update")
    public String updateArticle(@PathVariable("id") Long postId, @ModelAttribute("dto") PostDTO dto) {
        dto.setPostId(postId); // PostDTO에 ID 설정
        postService.updatePost(dto);
        return "redirect:/community"; // 업데이트 후 모든 게시글 보기 페이지로 리다이렉트
    }

    @PostMapping("update")
    public String updateArticle(PostDTO dto) {
        postService.updatePost(dto);
        return "redirect:/community";
    }

    ///////////////////////////////////// 댓글 처리 //////////////////////////////////////////
    @PostMapping("{id}/comments")
    public String insertComment(CommentDTO dto, @PathVariable("id") Long postId, HttpSession session) {
        String loggedInNickname = (String) session.getAttribute("userNickname");

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