package com.teamProject.tripPlan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class KakaoApiResponseDTO {
    // 카카오 API에서 반환받는 데이터를 담는 객체
    @JsonProperty("documents")
    private List<DocumentDTO> documents;
}
