package com.teamProject.tripPlan.dto;

import com.teamProject.tripPlan.entity.Suggestion;
import com.teamProject.tripPlan.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuggestionDTO {

    private Long suggestionId;
    private String suggestionTitle;
    private String suggestionContent;
    private LocalDateTime suggestionDate;
    private Users users;
    private List<CommentDTO> comments = new ArrayList<>();

    public static SuggestionDTO fromEntity(Suggestion suggestion) {
        return new SuggestionDTO(
                suggestion.getSuggestionId(),
                suggestion.getSuggestionTitle(),
                suggestion.getSuggestionContent(),
                suggestion.getSuggestionDate(),
                suggestion.getUsers(),
                suggestion.getComments().stream().map(x->CommentDTO.fromEntity(x)).toList()
        );
    }

    public static Suggestion fromDTO(SuggestionDTO dto) {
        Suggestion suggestion = new Suggestion();
        suggestion.setSuggestionId(dto.getSuggestionId());
        suggestion.setSuggestionTitle(dto.getSuggestionTitle());
        suggestion.setSuggestionContent(dto.getSuggestionContent());
        suggestion.setSuggestionDate(dto.getSuggestionDate());
        return suggestion;
    }
}
