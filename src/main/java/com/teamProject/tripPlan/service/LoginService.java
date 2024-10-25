package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.Users;
import com.teamProject.tripPlan.repository.LoginEntityRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    static LoginEntityRepository loginRepository;


    public static void joinProcess(UsersDTO joinDTO) {
        // 기존에 같은 아이디의 유저가 있는지 확인
        Boolean isUser = loginRepository.existsByUserEmail(joinDTO.getUserEmail());

        if (isUser) {
            return;
        }

        // 없으면 회원가입
        Users data = new Users();
        data.setUserEmail(joinDTO.getUserEmail());
//        data.setUserPassword();
    }

    public String findUsernameByEmail(String email) {
        User user = (User) loginRepository.findByUserEmail(email);
        return user != null ? user.getUsername() : null;
    }


}
