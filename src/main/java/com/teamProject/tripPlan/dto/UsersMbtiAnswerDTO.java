package com.teamProject.tripPlan.dto;

import com.teamProject.tripPlan.entity.AnswerOptions;
import com.teamProject.tripPlan.entity.MbtiQuestion;
import com.teamProject.tripPlan.entity.Users;
import com.teamProject.tripPlan.entity.UsersMbtiAnswer;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersMbtiAnswerDTO {
    private Long answerId;
    private MbtiQuestion mbtiQuestion;
    private Users users;
    private AnswerOptions answerOptions;

    public static UsersMbtiAnswerDTO fromEntity(UsersMbtiAnswer answer) {
        return new UsersMbtiAnswerDTO(
                answer.getAnswerId(),
                answer.getMbtiQuestion(),
                answer.getUsers(),
                answer.getAnswerOptions()
        );
    }

    public static UsersMbtiAnswer fromDTO(UsersMbtiAnswerDTO dto) {
        UsersMbtiAnswer answer = new UsersMbtiAnswer();
        answer.setAnswerId(dto.getAnswerId());
        answer.setMbtiQuestion(dto.getMbtiQuestion());
        answer.setUsers(dto.getUsers());
        answer.setAnswerOptions(dto.getAnswerOptions());
        return answer;
    }
}
