package org.example.chapter15.b_signup;

// 사용자가 회원가입 시 요청하는 데이터 형식

// 사용자 회원가입 요청 DTO
// DTO: Data Transfer Obj -> 데이터 전송 객체
// - 프로세스(계층) 간에 데이터를 전달하는 객체를 의미

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserSignUpRequestDto {
    private String username; //사용자 로그인 아이디
    private String password;
    private String passwordCheck;
    private String name;
    private String email;
    private String phone;
    private String nickname;

}
