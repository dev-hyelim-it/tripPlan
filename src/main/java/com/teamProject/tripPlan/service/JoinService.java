package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.entity.UserRole;
import com.teamProject.tripPlan.entity.Users;
import com.teamProject.tripPlan.repository.JoinRepository;
import com.teamProject.tripPlan.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    private final JoinRepository joinRepository;
    private final UserRepository userRepository;

    public JoinService(JoinRepository joinRepository, UserRepository userRepository) {
        this.joinRepository = joinRepository;
        this.userRepository = userRepository;
    }

    public void joinProcess(UsersDTO usersDTO) {
        // 기존에 중복된 아이디가 있는지 확인
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
//        data.setUserPassword(bCryptPasswordEncoder.encode(usersDTO.getUserPassword()));
        data.setUserPassword(usersDTO.getUserPassword());

        // 관리자 역할 설정(이메일이 "admin"인 경우 관리자 역할 부여)
        if ("admin".equals(usersDTO.getUserId())) {
            data.setRole(UserRole.ROLE_ADMIN);
        } else {
            data.setRole(UserRole.ROLE_USER);
        }

        // 결과 저장
        joinRepository.save(data);
    }

    public boolean isUserIdDuplicate(String userId) {
        return joinRepository.existsByUserId(userId);
    }

    public boolean isNicknameDuplicate(String userNickname) {
        return joinRepository.existsByUserNickname(userNickname);
    }
}
