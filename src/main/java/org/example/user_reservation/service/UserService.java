package org.example.user_reservation.service;

import org.example.user_reservation.dto.request.UserLoginRequestDto;
import org.example.user_reservation.dto.request.UserRegisterRequestDto;

public interface UserService {
    void registerUser(UserRegisterRequestDto dto);
    void login(UserLoginRequestDto dto);
    void logout();
    boolean isLoggedIn(); //사용자의 로그인 유무를 확인
}
