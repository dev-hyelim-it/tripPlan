package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.repository.MyListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyListService {

    @Autowired
    private MyListRepository myListRepository;

    public List<String> getTop5PlaceNames() {
        List<Object[]> top5Places = myListRepository.findTop5Places();
        return top5Places.stream()
                .map(obj -> (String)obj[0])
                .collect(Collectors.toList());
    }
}
