package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.entity.TravelDates;
import com.teamProject.tripPlan.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestContoller {
    @Autowired
    MyPageService myPageService;

    @GetMapping("test")
    public String test(Model model) {
        model.addAttribute("date", new TravelDates());
        return "/myPage/test";
    }

    @GetMapping("result")
    public String test2(TravelDates dates, Model model) {
        TravelDates dates1 = myPageService.insertDate(dates);
        System.out.println("트래블 아이디 : " + dates1.getTravelId() +
                "떠난 날 : " + dates1.getDeparture_date() + "도착한 날 : " + dates1.getArrival_date());
        return "redirect:/test";
    }
}
