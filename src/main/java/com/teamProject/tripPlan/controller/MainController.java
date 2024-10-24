package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.MainDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String Main() {
        return "main";
    }

    @PostMapping("/result")
    public String submit(@ModelAttribute MainDTO mainDTO, Model model) {
        // 받은 데이터 출력
//        System.out.println("Keyword: " + mainDTO.getKeyword());
//        System.out.println("Area: " + mainDTO.getArea());
//        System.out.println("Travel ID: " + mainDTO.getTravelId());
//        System.out.println("Departure Date: " + mainDTO.getDepartureDate());
//        System.out.println("Arrival Date: " + mainDTO.getArrivalDate());

        model.addAttribute("searchResult", mainDTO);
        // 결과 페이지로 리다이렉트 또는 이동
        return "result"; // result.html 페이지로 이동
    }
}
