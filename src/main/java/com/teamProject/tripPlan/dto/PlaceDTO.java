package com.teamProject.tripPlan.dto;

//import com.teamProject.tripPlan.entity.MyList;
import com.teamProject.tripPlan.entity.Place;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceDTO {
    private Long placeId;
    private String placeName; // 장소 이름
    private String addressName; // 전체 주소

    public static PlaceDTO fromEntity(Place place) {
        return new PlaceDTO(
                place.getPlaceId(),
                place.getPlaceName(),
                place.getAddressName()
        );
    }

    public static Place fromDTO(PlaceDTO dto) {
        Place place = new Place();
        place.setPlaceId(dto.getPlaceId());
        place.setPlaceName(dto.placeName);
        place.setAddressName(dto.addressName);
        return place;
    }
}
