package org.example.chapter09_pracice.exception;


// 사용자 예외 클래스
public class UserNotFoundException extends RuntimeException{

    // 실행 이전에는 예외발생이 되지않음
    public UserNotFoundException(String message) {
        super(message);
    }

}
