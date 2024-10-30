package com.teamProject.tripPlan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyListDTO {
    // 사용자가 선택한 장소 정보를 저장
    private String placeName; // 장소 이름
    private String addressName; // 전체 주소
    private String region1depthName; // 주소의 첫 번째 깊이 (시/도)
}
