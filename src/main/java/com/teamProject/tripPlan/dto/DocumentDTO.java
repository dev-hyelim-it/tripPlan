package com.teamProject.tripPlan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDTO {
//    개별 장소의 정보(예: 장소 이름, 주소, 좌표 등)를 담는 DTO
    //Kakao API의 documents 배열 안의 각 객체에 해당
    @JsonProperty("place_name")
    private String placeName;
    @JsonProperty("address_name")// 장소 이름
    private String addressName;      // 전체 주소
    private String x;                // 장소의 경도(longitude)
    private String y;                // 장소의 위도(latitude)
}
