package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dto.PlaceDTO;
import com.teamProject.tripPlan.entity.Place;

import com.teamProject.tripPlan.entity.Travel;
import com.teamProject.tripPlan.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelService {

    @Autowired
    private TravelRepository travelRepository;

    public void save(Travel travel) {
        travelRepository.save(travel);
    }
  
    // Travel ID로 장소 이름을 가져오는 메서드
    public List<PlaceDTO> getPlaceDTOsByTravelId(Long travelId) {
        Travel travel = travelRepository.findById(travelId)
                .orElseThrow(() -> new RuntimeException("Travel not found"));

        // 장소 리스트에서 이름만 추출하여 반환
        return travel.getPlaces().stream()
                .map(PlaceDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
