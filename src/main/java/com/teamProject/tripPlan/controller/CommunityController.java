package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.CommentDTO;
import com.teamProject.tripPlan.dto.PostDTO;
import com.teamProject.tripPlan.entity.Keyword;
import com.teamProject.tripPlan.entity.Post;
import com.teamProject.tripPlan.entity.Users;
import com.teamProject.tripPlan.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @GetMapping("")
    public String getAllPosts(Model model) {
        List<PostDTO> posts = postService.findAllPost();
        List<Keyword> allKeywords = keywordService.findAllKeywords();
        model.addAttribute("posts", posts);
        model.addAttribute("allKeywords", allKeywords);
        return "community"; // 템플릿 이름
    }

    @GetMapping("/filter")
    public String filterPostsByKeywords(@RequestParam(value = "keywords", required = false) List<String> keywords, Model model) {
        if (keywords == null || keywords.isEmpty() || keywords.get(0).isEmpty()) {
            // 모든 게시글을 반환
            List<PostDTO> allPosts = postService.findAllPost();
            model.addAttribute("posts", allPosts);
        } else {
            List<PostDTO> filteredPosts = postService.findPostsByKeyword(keywords);
            model.addAttribute("posts", filteredPosts);
        }
        return "community :: postList"; // 부분 업데이트를 위한 fragment 이름
    }

    @GetMapping("/new")
    public String newPostForm(Model model) {
        model.addAttribute("dto", new PostDTO());
        Users users = queryService.findOneUser("froggg");

        model.addAttribute("person", users);
        return "newPost";
    }

    @PostMapping("create")
    public String createPost(PostDTO dto, Model model, Principal principal) {
        Users users = queryService.findOneUser(principal.getName()); // 현재 로그인한 사용자의 이름으로 조회
        usersService.insertPost(users.getUserNo(), dto);
        return "redirect:/community";
    }


    @GetMapping("{id}")
    public String showOnePost(@PathVariable("id") Long id, Model model) {
        PostDTO dto = postService.getOnePost(id);
        model.addAttribute("dto", dto);
        log.info("================== myId = " + id + " ==================");
        postService.calculateLikes(id);
        return "showPost";
    }

    @GetMapping("{id}/delete")
    public String deleteArticle(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        postService.deletePost(id);

//        log.info("================== deleteId = " + id + " ==================");
//        queryService.deleteById(id);
        redirectAttributes.addFlashAttribute("msg", "정상적으로 삭제되었습니다.");
        return "redirect:/community";
    }

    @GetMapping("{id}/update")
    public String viewUpdateArticle(Model model, @PathVariable("id") Long postId) {
        model.addAttribute("dto", postService.getOnePost(postId));
        log.info(postService.getOnePost(postId).toString());
        return "updatePost";
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
