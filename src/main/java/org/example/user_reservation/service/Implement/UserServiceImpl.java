package org.example.user_reservation.service.Implement;

import org.example.user_reservation.dto.request.UserLoginRequestDto;
import org.example.user_reservation.dto.request.UserRegisterRequestDto;
import org.example.user_reservation.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void registerUser(UserRegisterRequestDto dto) {

    }

    @Override
    public void login(UserLoginRequestDto dto) {

    }

    @Override
    public void logout() {

    }

    @Override
    public boolean isLoggedIn() {
        return false;
    }
}
