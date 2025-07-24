package org.example.user_reservation.service.Implement;

import lombok.Getter;
import org.example.user_reservation.dto.request.UserLoginRequestDto;
import org.example.user_reservation.dto.request.UserRegisterRequestDto;
import org.example.user_reservation.entity.User;
import org.example.user_reservation.repository.UserRepository;
import org.example.user_reservation.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Getter
    private final UserRepository userRepository;
    private User loggedUser; //로그인 된 사용자 정보를 저장하는 필드

    public UserServiceImpl() {
        this.userRepository = new UserRepository();
    }



    @Override
    public void registerUser(UserRegisterRequestDto dto) {
        // 해당 Dto 내부의 userId 값을 사용해 기존의 데이터와 비교
        Optional<User> optionalUser = userRepository.findByUserId(dto.getUserId());

        // Optional 데이터 가져올 땐 get()을 씀
        // : Optional 내부의 데이터를 반환해줌
        // - 값이 존재하지 않을 때 NoSuchElementException 예외 발생
        Optional<String> optional = Optional.empty();

        // +) .isPresent, isEmpty()
        if (optionalUser.isPresent()) {
            // 해당 id의 유저가 존재 -> 회원가입 불가능
            System.out.println("해당 ID의 유저가 존재합니다. 다시 시도해주세요");
            return;
        }



        // 비밀번호 확인 로직
        String password = dto.getPassword();
        String passwordCheck = dto.getPasswordCheck();

        if (!password.equals(passwordCheck)) {
            // 비밀번호와 비밀번호 확인값이 일치하지 않음 -> 회원가입 못함
            System.out.println("비밀번호 틀림");
            return;
        }

        // 회원가입 정상 로직 실행
        User newUser = new User(dto.getUserId(), password, dto.getName(), dto.getEmail());
        userRepository.save(newUser);
        System.out.println("사용자 회원가입 완료: " + dto.getName() + "님, 환영합니다.");
    }

    @Override
    public void login(UserLoginRequestDto dto) {
        String userId = dto.getUserId();
        String password = dto.getPassword();


        // ifPresentOrElse(a,b)
        // : 정보가 존재하는 경우 a 로직 실행, 존재하지 않을 경우 b로직 실행
        userRepository.findByUserId(userId)
                .ifPresentOrElse(user -> {
                    // 데이터가 있는 경우
                    // user 값 내부의 password 값과 dto 요청 값 내부의 비밀번호 값의 일치 여부 확인
                    if (user.getPassword().equals(password)) {
                        loggedUser = user; //로그인 정보 저장
                        System.out.println("로그인 성공: " + user.getName());
                    } else {
                        System.out.println("로그인 실패: 비밀번호가 일치하지 않아용");
                    }},
                       () -> System.out.println("로그인 실패: 사용자 ID를 찾을 수 없습니다."));

    }

    @Override
    public void logout() {
        if (loggedUser != null) {
            // 로그인 중
            System.out.println("로그아웃 성공: " +loggedUser.getName());
            loggedUser = null;
        } else {
            System.out.println("로그인 상태가 아닙니다. 로그아웃 할 수 없습니다.");
        }
    }

    @Override
    public boolean isLoggedIn() {
        boolean result = loggedUser != null; //불일치 여부 확인 연산자
        // -> null 이면 false : 로그인 X
        // -> notnull 이면 true : 로그인 O




        return false;
    }

}
