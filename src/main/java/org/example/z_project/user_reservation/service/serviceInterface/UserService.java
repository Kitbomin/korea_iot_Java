package org.example.z_project.user_reservation.service.serviceInterface;

import org.example.z_project.user_reservation.dto.request.UserLoginRequestDto;
import org.example.z_project.user_reservation.dto.request.UserRegisterRequestDto;
import org.example.z_project.user_reservation.entity.User;

import java.util.Optional;

public interface UserService {
    void registerUser(UserRegisterRequestDto dto);
    void login(UserLoginRequestDto dto);
    void logout();
    boolean isLoggedIn(); //사용자의 로그인 유무를 확인
    Optional<User> findUserById(String userId);
}
