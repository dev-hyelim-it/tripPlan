package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dto.MyListDTO;
import com.teamProject.tripPlan.dto.PlaceDTO;
import com.teamProject.tripPlan.entity.MyList;
import com.teamProject.tripPlan.entity.Place;
import com.teamProject.tripPlan.entity.Travel;
import com.teamProject.tripPlan.repository.MyListRepository;
import com.teamProject.tripPlan.repository.PlaceRepository;
import com.teamProject.tripPlan.repository.TravelRepository;
import com.teamProject.tripPlan.repository.UserRepository;
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
    private final TravelRepository travelRepository;
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;
    @Autowired
    MyPageService myPageService;

    @Autowired
    public MyListService(MyListRepository myListRepository, TravelRepository travelRepository, UserRepository userRepository, PlaceRepository placeRepository) {
        this.myListRepository = myListRepository;
        this.travelRepository = travelRepository;
        this.userRepository = userRepository;
        this.placeRepository = placeRepository;
    }

    public void saveMyList(List<MyListDTO> myListDTOs) {
        System.out.println(travelRepository.findById(1L));
        Travel travel = travelRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<MyList> myLists = myListDTOs.stream().map(x->MyListDTO.fromDTO(x)).toList();

        System.out.println("===============" + myLists);
        System.out.println("Received userNo: " + travel.getTravelId());
        myListRepository.saveAll(myLists);
    }

    public void saveTest(List<PlaceDTO> placeDTO) {
        List<Place> place = placeDTO.stream().map(x->PlaceDTO.fromDTO(x)).toList();
        System.out.println(place);
        placeRepository.saveAll(place);
    }

//    public Travel insertDate(Travel travel) {
//        Travel travel1 = new Travel();
//        travel1.setStartDate(travel1.getStartDate());
//        travel1.setEndDate(travel1.getEndDate());
//        travelRepository.save(travel);
//        return travel;
//    }

    public List<String> getTop5PlaceNames() {
        List<Object[]> top5Places = myListRepository.findTop5Places();
        return top5Places.stream()
                .map(obj -> (String)obj[0])
                .collect(Collectors.toList());
    }

    public void saveList(Long travelId, List<PlaceDTO> placeDTO) {
        List<Place> place = placeDTO.stream().map(x -> PlaceDTO.fromDTO(x)).toList();
        myPageService.insertTravel(travelId, place);
    }
}
