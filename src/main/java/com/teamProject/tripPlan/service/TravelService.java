package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.entity.Travel;
import com.teamProject.tripPlan.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelService {

    @Autowired
    private TravelRepository travelRepository;

    public void save(Travel travel) {
        travelRepository.save(travel);
    }
}
