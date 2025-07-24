package org.example.user_reservation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class UserRegisterRequestDto {
    private String userId;
    private String password;
    private String passwordCheck; // Entity User와의 차이 -> 얘는 저장할 필요는 없음
    private String name;
    private String email;
}
