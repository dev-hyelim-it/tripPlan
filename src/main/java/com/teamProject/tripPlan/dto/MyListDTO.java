package com.teamProject.tripPlan.dto;

import com.teamProject.tripPlan.entity.MyList;
import com.teamProject.tripPlan.entity.Travel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyListDTO {
    // 사용자가 선택한 장소 정보를 저장
    private Long myListId;
    private String placeName; // 장소 이름
    private String addressName; // 전체 주소

    public static MyListDTO fromEntity(MyList myList) {
        return new MyListDTO(
                myList.getMyListId(),
                myList.getPlaceName(),
                myList.getPlaceAddress()
        );
    }

    public static MyList fromDTO(MyListDTO dto) {
        MyList myList = new MyList();
        myList.setMyListId(dto.getMyListId());
        myList.setPlaceName(dto.placeName);
        myList.setPlaceAddress(dto.addressName);
        return myList;
    }

}
