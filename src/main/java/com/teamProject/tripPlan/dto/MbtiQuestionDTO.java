package com.teamProject.tripPlan.dto;

import com.teamProject.tripPlan.entity.AnswerOptions;
import com.teamProject.tripPlan.entity.UsersMbtiAnswer;
import com.teamProject.tripPlan.entity.MbtiQuestion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MbtiQuestionDTO {

    private Long questionId;
    private String questionText;
    private String questionType;
    private List<UsersMbtiAnswer> usersMbtiAnswer;
    private List<AnswerOptions> answerOptions = new ArrayList<>();

    public static MbtiQuestionDTO fromEntity(MbtiQuestion question) {
        return new MbtiQuestionDTO(
                question.getQuestionId(),
                question.getQuestionText(),
                question.getQuestionType(),
                question.getUsersMbtiAnswers(),
                question.getAnswerOptions()
        );
    }

    public static MbtiQuestion fromDTO(MbtiQuestionDTO dto) {
        MbtiQuestion question = new MbtiQuestion();
        question.setQuestionId(dto.getQuestionId());
        question.setQuestionText(dto.getQuestionText());
        question.setQuestionType(dto.getQuestionType());
        question.setUsersMbtiAnswers(dto.getUsersMbtiAnswer());
        question.setAnswerOptions(dto.getAnswerOptions());
        return question;
    }

}
