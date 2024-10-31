package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.CommentDTO;
import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.entity.*;
import com.teamProject.tripPlan.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    CommentService commentService;

    @Autowired
    KeywordService keywordService;

    @Autowired
    MyPageService myPageService;

    @GetMapping("")
    public String getAllPosts(Model model) {
        List<PostDTO> posts = postService.findAllPost();
        List<Keyword> allKeywords = keywordService.findAllKeywords();
        model.addAttribute("posts", posts);
        model.addAttribute("allKeywords", allKeywords);
        return "community/community"; // 템플릿 이름
    }

    @GetMapping("/filter")
    public String filterPostsByKeywords(@RequestParam(value = "keywords", required = false) List<String> keywords, Model model) {
        if (keywords == null || keywords.isEmpty() ||
                keywords.get(0).isEmpty()) {
            // 모든 게시글을 반환
            List<PostDTO> allPosts = postService.findAllPost();
            model.addAttribute("posts", allPosts);
        } else {
            List<PostDTO> filteredPosts = postService.findPostsByKeyword(keywords);
            model.addAttribute("posts", filteredPosts);
        }
        return "community/community :: postList"; // 부분 업데이트를 위한 fragment 이름
    }

    @GetMapping("/new")
    public String newPostForm(Model model) {
        PostDTO postDTO = new PostDTO();
        postDTO.setKeywords(new ArrayList<>()); // 초기화
        model.addAttribute("dto", postDTO);

        Users users = queryService.findOneUser("1111");
        model.addAttribute("person", users);

        List<MyList> myLists = myPageService.findAllMyLists();
        model.addAttribute("travelLists", myLists);

        List<Keyword> allKeywords = keywordService.findAllKeywords();
        model.addAttribute("allKeywords", allKeywords);

        return "community/newPost";
    }

    @PostMapping("create")
    public String createPost(@ModelAttribute("dto") PostDTO dto, Model model, Principal principal) {
        Users users = queryService.findOneUser("1111"); // 현재 로그인한 사용자의 이름으로 조회
        dto.setUsers(users); // 현재 사용자 설정
//        dto.setPostDate(LocalDateTime.now()); // 현재 날짜와 시간 설정

        // Travel 객체 설정
        if (dto.getTravel() != null) {
            Travel travel = dto.getTravel();
            travel.setUsers(users); // 사용자를 Travel에 설정
            dto.setTravel(travel);
        }

        usersService.insertPost(users.getUserNo(), dto);
        return "redirect:/community"; // 모든 게시글 보기 페이지로 리다이렉트
    }

    @GetMapping("{id}")
    public String showOnePost(@PathVariable("id") Long id, Model model) {
        PostDTO dto = postService.getOnePost(id);
        model.addAttribute("dto", dto);
        log.info("================== myId = " + id + " ==================");
        postService.calculateLikes(id);
        return "community/showPost";
    }

    @GetMapping("{id}/delete")
    public String deleteArticle(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        postService.deletePost(id);
        redirectAttributes.addFlashAttribute("msg", "정상적으로 삭제되었습니다.");
        return "redirect:/community"; // 삭제 후 모든 게시글 보기 페이지로 리다이렉트
    }

    @GetMapping("{id}/update")
    public String viewUpdateArticle(Model model, @PathVariable("id") Long postId) {
        PostDTO postDTO = postService.getOnePost(postId);
        model.addAttribute("dto", postDTO);
        log.info("Updating post: {}", postDTO);
        return "community/updatePost"; // updatePost 템플릿으로 이동
    }

    @PostMapping("{id}/update")
    public String updateArticle(@PathVariable("id") Long postId, @ModelAttribute("dto") PostDTO dto) {
        dto.setPostId(postId); // PostDTO에 ID 설정
        postService.updatePost(dto);
        return "redirect:/community"; // 업데이트 후 모든 게시글 보기 페이지로 리다이렉트
    }

    @PostMapping("update")
    public String updateArticle(PostDTO dto) {
        System.out.println(dto);
        postService.updatePost(dto);
        return "redirect:/community";
    }

    ///////////////////////////////////// 댓글 처리 //////////////////////////////////////////
    @PostMapping("{id}/comments")
    public String insertComment(CommentDTO dto, @PathVariable("id") Long postId) {
//        dto.setCommentId(null);
        System.out.println(dto.toString());
        commentService.insertComment(postId, dto);
        return "redirect:/community/" + postId;
    }

    @GetMapping("comments/{id}")
    public String deleteComment(@PathVariable("id") Long commentId) {
        Long postId = commentService.deleteComment(commentId);
        return "redirect:/community/" + postId;
    }

    @GetMapping("comments/view/{id}")
    public String updateCommentForm(Model model, @PathVariable("id") Long commentId) {
        Map<String, Object> map = commentService.findByCommentId(commentId);
        model.addAttribute("comment", map.get("comment"));
        model.addAttribute("postId", map.get("postId"));
        Long postId = (Long) map.get("postId");
        PostDTO dto = postService.getOnePost(postId);
        model.addAttribute("dto", dto);

        return "updateComment";
    }

    @PostMapping("{postId}/comments/{commentId}")
    public String updateComment(@PathVariable("postId") Long postId,
                                @PathVariable("commentId") Long commentId,
                                CommentDTO dto) {
        dto.setCommentId(commentId);
        commentService.updateComment(dto);
        return "redirect:/community/" + postId;
    }
}