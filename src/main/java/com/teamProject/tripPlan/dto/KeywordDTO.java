package com.teamProject.tripPlan.dto;

import com.teamProject.tripPlan.entity.Keyword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KeywordDTO {

    private Long keywordId;
    private String keyword;


    public static KeywordDTO fromEntity(Keyword keyword) {
        return new KeywordDTO(
                keyword.getKeywordId(),
                keyword.getKeyword()
        );
    }

    public static Keyword fromDTO(KeywordDTO dto) {
        Keyword keyword = new Keyword();
        keyword.setKeywordId(dto.getKeywordId());
        keyword.setKeyword(dto.getKeyword());
        return keyword;
    }

}
