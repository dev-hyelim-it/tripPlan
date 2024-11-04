package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.UsersMbtiAnswerDTO;
import com.teamProject.tripPlan.entity.*;
import com.teamProject.tripPlan.repository.QuestionRepository;
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

@Slf4j
@Controller
@RequestMapping("typeTest")
public class MbtiController {

    @Autowired
    QuestionService questionService;

    @Autowired
    MbtiTestResultService mbtiTestResultService;

    @Autowired
    QueryService queryService;

    @Autowired
    UsersMbtiAnswerService usersMbtiAnswerService;

    @GetMapping("")
    public String testMainForm(Model model) {
//        model.addAttribute("questionLists", questionService.findAll());
        model.addAttribute("questionId", 1);
        return "mbti/testMainForm";
    }

//    @GetMapping("question")
//    public String testQuestion(Model model) {
//        model.addAttribute("questions", questionRepository.findAll());
//        return "mbti/Question";
//    }

    @GetMapping("question/{questionId}")
    public String testQuestion(@PathVariable("questionId") Long questionId, Model model) {
        MbtiQuestion mbtiQuestion = questionService.findById(questionId);
        model.addAttribute("question", mbtiQuestion);
        AnswerOptions answer1 = mbtiQuestion.getAnswerOptions().get(0);
        AnswerOptions answer2 = mbtiQuestion.getAnswerOptions().get(1);
        model.addAttribute("answer1", answer1);
        model.addAttribute("answer2", answer2);
        UsersMbtiAnswerDTO dto = new UsersMbtiAnswerDTO();
        dto.setMbtiQuestion(mbtiQuestion);

        model.addAttribute("dto", dto);

        return "mbti/question";
    }

    @PostMapping("insertUsersAnswer")
    public String insertUsersAnswer(UsersMbtiAnswerDTO dto, @RequestParam("questionId") Long questionId,
                                    @RequestParam("optionId") Long optionId,
                                    Principal principal) {
        // 디버깅 로그 추가
        if (dto.getMbtiQuestion() != null) {
            log.info("MbtiQuestion ID: " + dto.getMbtiQuestion().getQuestionId());
        } else {
            log.warn("MbtiQuestion is null in dto");
        }

        if (optionId != null) {
            log.info("AnswerOptions ID: " + optionId);
        } else {
            log.warn("AnswerOptions is null in dto");
        }

        if (questionId != null) {
            log.info("Question ID: " + questionId);
        } else {
            log.warn("Received questionId is null");
        }

        // Users 정보 확인
        Users users = queryService.findOneUser(principal.getName()); // 로그인한 아이디로 변경
        if (users != null) {
            log.info("User ID: " + users.getUserNo());
        } else {
            log.warn("Users object is null");
        }

        // 실제 로직 수행
        usersMbtiAnswerService.insertAnswer(users.getUserNo(), questionId, optionId);

        Long nextQuestionId = questionId + 1; // 다음 질문 ID 설정
        if(nextQuestionId <= 6){
            return "redirect:/typeTest/question/" + nextQuestionId;
        } else {
            return "redirect:/typeTest/result";
        }

    }

    @GetMapping("result")
    public String resultPage(Model model, Principal principal, RedirectAttributes redirectAttributes, HttpSession session) {
        model.addAttribute("results", mbtiTestResultService.findAll());
        Users users = queryService.findOneUser(principal.getName()); // 로그인한 아이디로 변경
        List<UsersMbtiAnswer> usersMbtiAnswers = usersMbtiAnswerService.findByUserNo(users.getUserNo());

        int natureCount = 0;
        int cityCount = 0;
        int healingCount = 0;
        int activityCount = 0;

        for (UsersMbtiAnswer answer : usersMbtiAnswers) {
            OptionType optionType = answer.getAnswerOptions().getOptionType();

            switch (optionType) {
                case NATURE:
                    natureCount ++;
                    break;
                case CITY:
                    cityCount ++;
                    break;
                case HEALING:
                    healingCount ++;
                    break;
                case ACTIVITY:
                    activityCount ++;
                    break;
                default:
                    break;
            }
        }

        String activityPreference = (healingCount > activityCount) ? "H" : "A";
        String environmentPreference = (natureCount > cityCount) ? "N" : "C";

        log.info(activityPreference+environmentPreference);

        ResultType myResultType = ResultType.valueOf(activityPreference + environmentPreference);
        log.info("myResultType = " + myResultType);

        MbtiTestResult mbtiTestResult = mbtiTestResultService.findByResultType(myResultType);
//        mbtiTestResult.getDescription()
        model.addAttribute("userNickname", users.getUserNickname());
        model.addAttribute("myResult", mbtiTestResult);
        users.setResultType(myResultType);

        // 결과가 생성된 후 usersMbtiAnswer 데이터 삭제
        usersMbtiAnswerService.deleteByUserNo(users.getUserNo());

        return "mbti/testResult";
    }
}