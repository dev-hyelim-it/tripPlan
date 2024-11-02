package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.service.JoinService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
public class JoinController {
    private final JoinService joinService;
    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    // 회원가입 페이지
    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("dto", new UsersDTO());
        return "member/join";
    }
    //
    // 회원가입 처리
    @PostMapping("/joinProc")
    public String joinProcess(UsersDTO usersDTO, Model model, RedirectAttributes redirectAttributes) {
        String idPattern = "^[0-9a-zA-Z]{4,10}$";
        String nicknamePattern = "^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|]{2,8}$";

        if (!usersDTO.getUserId().matches(idPattern)) {
            model.addAttribute("error1", "아이디는 영문자와 숫자로 4~10자여야 합니다.");
            model.addAttribute("dto", usersDTO);
            return "member/join";
        } if (joinService.isUserIdDuplicate(usersDTO.getUserId())){
            model.addAttribute("error1", "이미 사용중인 아이디 입니다.");
            model.addAttribute("dto", usersDTO);
            return "member/join";
        } if (joinService.isNicknameDuplicate(usersDTO.getUserNickname())){
            model.addAttribute("error2", "이미 사용중인 닉네임 입니다.");
            model.addAttribute("dto", usersDTO);
            return "member/join";
        } if (!usersDTO.getUserNickname().matches(nicknamePattern)) {
            model.addAttribute("error2", "닉네임은 영문자, 한글 또는 숫자로 2~8자여야 합니다.");
            model.addAttribute("dto", usersDTO);
            return "member/join";
        } if (joinService.isUserEmailDuplicate(usersDTO.getUserEmail())){
            model.addAttribute("error3", "이미 사용중인 이메일 입니다.");
            model.addAttribute("dto", usersDTO);
            return "member/join";
        }

        boolean joinSuccess = joinService.joinProcess(usersDTO);
        if (joinSuccess) {
            redirectAttributes.addFlashAttribute("joinSuccess", "회원가입이 완료되었습니다.");
            return "redirect:/login";
        } else {
            model.addAttribute("error", "회원가입 처리 중 오류가 발생했습니다. 다시 시도해 주세요.");
            model.addAttribute("dto", usersDTO);
            return "member/join";
        }
    }
}
