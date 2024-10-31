package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.UserRole;
import com.teamProject.tripPlan.entity.Users;
import com.teamProject.tripPlan.repository.JoinRepository;
import com.teamProject.tripPlan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    JoinRepository joinRepository;

    public void joinProcess(UsersDTO usersDTO) {
        // 기존에 같은 아이디의 유저가 있는지 중복된 이메일로 확인
        Boolean isUser = joinRepository.existsByUserId(usersDTO.getUserId());
        Users users = joinRepository.findByUserId(usersDTO.getUserId());

        if (isUser) {
            return; // 중복 유저일 경우 메서드 종료
        }

        // 없으면 회원가입 절차 진행
        Users data = new Users();
        data.setUserId(usersDTO.getUserId());
        data.setUserName(usersDTO.getUserName());
        data.setUserNickname(usersDTO.getUserNickname());
        data.setUserEmail(usersDTO.getUserEmail());
        // 비밀번호는 암호화 하여 DB에 저장
        data.setUserPassword(bCryptPasswordEncoder.encode(usersDTO.getUserPassword()));

        // 관리자 역할 설정(아이디가 "admin"인 경우 관리자 역할 부여)
        if ("admin".equals(usersDTO.getUserId())) {
            data.setRole(UserRole.ROLE_ADMIN);
        } else {
            data.setRole(UserRole.ROLE_USER);
        }
        joinRepository.save(data);
    }
}
