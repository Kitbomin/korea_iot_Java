package org.example.user_reservation.controller;

import org.example.user_reservation.dto.request.UserLoginRequestDto;
import org.example.user_reservation.dto.request.UserRegisterRequestDto;
import org.example.user_reservation.dto.response.ReservationResponseDto;
import org.example.user_reservation.service.Implement.ReservationServiceImpl;
import org.example.user_reservation.service.Implement.UserServiceImpl;
import org.example.user_reservation.service.serviceInterface.ReservationService;
import org.example.user_reservation.service.serviceInterface.UserService;

import java.util.List;
import java.util.Scanner;

public class ReservationController {
    // 서비스 로직이 User, Reservation으로 갈수도 있음

    private final UserService userService;
    private final ReservationService reservationService;

    public ReservationController() {
        this.userService = new UserServiceImpl();
        this.reservationService = new ReservationServiceImpl(userService);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getChoice(sc);

            if (!processChoice(choice, sc)) {
                break; // processChoice의 반환이 false인 경우 무한루프 종료( 7 입력 >> false 반환)
            }
        }

    }

    private void displayMenu() {
        System.out.println("1. 사용자 등록 | 2. 로그인 | 3. 로그아웃");
        System.out.println("4. 예약 등록 | 5. 예약 확인 | 6. 예약 취소");
        System.out.println("7. 종료");
        System.out.print("선택 >>");
    }

    private int getChoice(Scanner sc) {
        while (!sc.hasNextInt()) { //입력값이 false여야 무한루프 돈다
            //hasNextInt() : 입력값이 int 라면 true, 그렇지 않다면 false


            // 입력값이 정수가 아닌 경우
            System.out.println("숫자를 입력해주세요.");
            sc.next();
        }

        return sc.nextInt();

    }

    // run에서 돌리기 위한 값
    private boolean processChoice (int choice, Scanner sc) {
        sc.nextLine(); // getChoice에서 정수값을 입력받고 남은 버퍼를 처리

        switch (choice) {
            case 1:
                userService.registerUser(
                        new UserRegisterRequestDto(
                                input(sc, "사용자 ID"),
                                input(sc, "사용자 비밀번호"),
                                input(sc, "사용자 비밀번호 확인"),
                                input(sc, "사용자 이름"),
                                input(sc, "사용자 이메일")
                        ));
                break;
            case 2:
                userService.login(
                        new UserLoginRequestDto(
                                input(sc, "사용자 ID"),
                                input(sc, "사용자 비밀번호")
                        )
                );
                break;

            case 3:
                userService.logout();
                break;

            case 4:
                reservationService.createReservation(input(sc, "사용자 ID"));
                break;

            case 5:
                List<ReservationResponseDto> results = reservationService.getReservationByUserId(
                        input(sc, "사용자 ID")
                );

                results.forEach(System.out::println);
                break;

            case 6:
                String reservationId = input(sc, "예약 ID");
                try {
                    Long id = Long.parseLong(reservationId);
                    reservationService.cancelReservation(id);

                }catch (NumberFormatException e) {
                    System.out.println("예약 ID는 숫자여야합니다. 다시 시도해주세요.");
                }

                break;

            case 7:
                System.out.println("프로그램을 종료합니다.");
                return false;

            default:
                System.out.println("잘못된 선택입니다. 유효한 기능을 선택하세요(1~7)");
        }
        return true;
    }


    private String input(Scanner sc, String prompt) {
        System.out.print(prompt + ": ");

        return sc.nextLine();
    }



}
