//package com.teamProject.tripPlan.service;
//
//import com.teamProject.tripPlan.entity.Users;
//import com.teamProject.tripPlan.repository.LoginEntityRepository;
//import dto.JoinDTO;
//import org.apache.catalina.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LoginService {
//    @Autowired
//    LoginEntityRepository loginRepository;
//
//    public void joinProcess(JoinDTO joinDTO) {
//        // 기존에 같은 아이디의 유저가 있는지 확인
//        Boolean isUser = loginRepository.existsByUserEmail(joinDTO.getEmail());
//
//        if (isUser) {
//            return;
//        }
//
//        // 없으면 회원가입
//        Users data = new Users();
//        data.setUserEmail(joinDTO.getEmail());
////        data.setUserPassword();
//    }
//
//    public String findUsernameByEmail(String email) {
//        User user = (User) loginRepository.findByUserEmail(email);
//        return user != null ? user.getUsername() : null;
//    }
//}
