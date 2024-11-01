package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.CommentDTO;
import com.teamProject.tripPlan.dto.SuggestionCommentDTO;
import com.teamProject.tripPlan.dto.SuggestionDTO;
import com.teamProject.tripPlan.entity.Users;
import com.teamProject.tripPlan.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/suggestion")
public class SuggestionController {

    @Autowired
    SuggestionService suggestionService;

    @Autowired
    QueryService queryService;

    @Autowired
    UsersService usersService;

    @Autowired
    SuggestionCommentService commentService;

    @GetMapping("/box")
    public String suggestionBoxView(Model model, Principal principal) {
        List<SuggestionDTO> suggestions = suggestionService.findAllSuggestion();
        model.addAttribute("suggestions", suggestions);
        Users users = queryService.findOneUser(principal.getName());
        for (SuggestionDTO dto : suggestions) {
            if (dto.getUsers().getUserNickname().equals(users.getUserNickname())) {
                dto.setOpenType(1);
            } else if (users.getUserNickname().equals("admin")) {
                dto.setOpenType(1);
            } else {
                dto.setOpenType(0);
            }
        }
        return "suggestion/suggestionBox";
    }

    @GetMapping("/new")
    public String newSuggestionForm(Model model, Principal principal) {
        model.addAttribute("dto", new SuggestionDTO());
        Users users = queryService.findOneUser(principal.getName());
        List<SuggestionDTO> suggestionDTOS = suggestionService.findAllSuggestion();
//        List<Suggestion> suggestions = suggestionService.findAllSuggestion().stream().map(x->SuggestionDTO.fromDTO(x)).toList();
//        model.addAttribute("myNickname", users.getUserNickname());
        return "suggestion/newSuggestion";
    }

    @PostMapping("create")
    public String createSuggestion(SuggestionDTO dto, Model model, Principal principal) {
        Users users = queryService.findOneUser(principal.getName());
//        model.addAttribute("myNickname", users.getUserNickname());
        usersService.insertSuggestion(users.getUserNo(), dto);
        // 로그인한 사람의 아이디가 동일한 사람 찾기
        return "redirect:/suggestion/box";
    }

    @GetMapping("{id}")
    public String showOneSuggestion(@PathVariable("id") Long id, Model model) {
        SuggestionDTO dto = suggestionService.getOneSuggestion(id);
        model.addAttribute("dto", dto);
        return "suggestion/showSuggestion";
    }

    @GetMapping("{id}/delete")
    public String deleteSuggestion(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        suggestionService.deleteSuggestion(id);
        redirectAttributes.addFlashAttribute("msg", "정상적으로 삭제되었습니다.");
        return "redirect:/suggestion/box";
    }

    @GetMapping("{id}/update")
    public String viewUpdateSuggestion(Model model, @PathVariable("id") Long suggestionId) {
        model.addAttribute("dto", suggestionService.getOneSuggestion(suggestionId));
        return "/suggestion/updateSuggestion";
    }

    @PostMapping("update")
    public String updateSuggestion(SuggestionDTO dto) {
        System.out.println(dto);
        suggestionService.updateSuggestion(dto);
        return "redirect:/suggestion/box";
    }

    ///////////////////////////////////// 댓글 처리 //////////////////////////////////////////
    @PostMapping("{id}/comments")
    public String insertSuggestionComment(SuggestionCommentDTO dto, @PathVariable("id") Long suggestionId) {
        System.out.println(dto.toString());
        commentService.insertSuggestionComment(suggestionId, dto);
        return "redirect:/suggestion/" + suggestionId;
    }

    @GetMapping("comments/{id}")
    public String deleteSuggestionComment(@PathVariable("id") Long CommentId) {
        Long suggestionId = commentService.deleteSuggestionComment(CommentId);
        return "redirect:/suggestion/" + suggestionId;
    }

    @GetMapping("comments/view/{id}/update")
    public String updateCommentForm(Model model, @PathVariable("id") Long commentId) {
        Map<String, Object> map = commentService.findBySuggestionCommentId(commentId);
        model.addAttribute("comment", map.get("comment"));
        model.addAttribute("suggestionId", map.get("suggestionId"));
        Long suggestionId = (Long) map.get("suggestionId");
        SuggestionDTO dto = suggestionService.getOneSuggestion(suggestionId);
        model.addAttribute("dto", dto);

        return "suggestion/updateSuggestionComment";
    }

    @PostMapping("{suggestionId}/comments/{commentId}")
    public String updateComment(@PathVariable("suggestionId") Long suggestionId,
                                @PathVariable("commentId") Long commentId,
                                SuggestionCommentDTO dto) {
        dto.setCommentId(commentId);
        commentService.updateComment(dto);
        return "redirect:/suggestion/" + suggestionId;
    }
}
