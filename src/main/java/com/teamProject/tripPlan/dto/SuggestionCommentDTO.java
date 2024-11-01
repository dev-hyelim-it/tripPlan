package com.teamProject.tripPlan.dto;

import com.teamProject.tripPlan.entity.Comment;
import com.teamProject.tripPlan.entity.SuggestionComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuggestionCommentDTO {
    private Long commentId;
    private String commentNickname;
    private String commentContent;

    public static SuggestionCommentDTO fromEntity(SuggestionComment comment) {
        return new SuggestionCommentDTO(
                comment.getCommentId(),
                comment.getCommentNickname(),
                comment.getCommentContent()
        );
    }

    public static SuggestionComment fromDTO(SuggestionCommentDTO dto) {
        SuggestionComment comment = new SuggestionComment();
        comment.setCommentId(dto.getCommentId());
        comment.setCommentNickname(dto.getCommentNickname());
        comment.setCommentContent(dto.getCommentContent());
        return comment;
    }

}
