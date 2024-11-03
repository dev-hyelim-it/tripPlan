package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.entity.Place;
import com.teamProject.tripPlan.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository; // 장소 정보를 가져올 리포지토리

    // ID로 장소 조회
    public Place findById(Long id) {
        return placeRepository.findById(id).orElse(null); // ID가 있는 경우 해당 장소 반환, 없으면 null 반환
    }

    // 필요에 따라 추가적인 메서드도 정의할 수 있음
}