package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.service.JoinService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class JoinController {
    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @GetMapping("join")
    public String join(Model model) {
        model.addAttribute("dto", new UsersDTO());
        return "member/join";
    }

    @GetMapping("/checkDuplicate")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkDuplicate(@RequestParam(required = false) String userId,
                                                              @RequestParam(required = false) String userNickname) {
        Map<String, Object> response = new HashMap<>();
        boolean isDuplicate = false;

        if (userId != null) {
            isDuplicate = joinService.isUserIdDuplicate(userId);
        } else if (userNickname != null) {
            isDuplicate = joinService.isNicknameDuplicate(userNickname);
        }

        response.put("success", !isDuplicate);
        response.put("msg", isDuplicate ? "이미 사용 중입니다." : "사용 가능합니다.");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/joinProc")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> joinProcess(@RequestBody UsersDTO usersDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
            joinService.joinProcess(usersDTO);
            response.put("success", true);
            response.put("msg", "회원가입이 완료되었습니다.");
        } catch (Exception e) {
            response.put("success", false);
            response.put("msg", "회원가입 중 오류가 발생했습니다: " + e.getMessage());
        }
        return ResponseEntity.ok(response);
    }
}
