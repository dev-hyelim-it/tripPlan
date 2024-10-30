package com.teamProject.tripPlan.dto;

import com.teamProject.tripPlan.entity.Comment;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long commentId;
    private String commentNickname;
    private String commentContent;

    public static CommentDTO fromEntity(Comment comment) {
        return new CommentDTO(
                comment.getCommentId(),
                comment.getCommentNickname(),
                comment.getCommentContent()
        );
    }

    public static Comment fromDTO(CommentDTO dto) {
        Comment comment = new Comment();
        comment.setCommentId(dto.getCommentId());
        comment.setCommentNickname(dto.getCommentNickname());
        comment.setCommentContent(dto.getCommentContent());
        return comment;
    }


}
