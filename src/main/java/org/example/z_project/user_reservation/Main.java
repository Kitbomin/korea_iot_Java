package org.example.z_project.user_reservation;

import org.example.z_project.user_reservation.controller.ReservationController;

/**
 * == 프로젝트 개요 ==
 * : 온라인 예약 시스템
 *
 * - 사용자가 회원가입 후 로그인을 해야만 예약 시스템에 접근이 가능함
 * - 예약은 등록, 조회, 취소 기능 포함
 * - 사용자는 시스템 활용이 끝나면 로그아웃 기능을 사용할 수 있음
 *
 * 1) 기능
 *      - 사용자 관리: 사용자 등록(회원가입), 로그인, 로그아웃
 *      - 예약 관리:
 *              >> 예약 등록: 특정 시간에 예약
 *              >> 예약 조회: 자신의 예약 목록 확인
 *              >> 예약 취소: 자신의 예약을 취소
 *
 * 2) 프로그램 구성 요소
 *      - 모델: 사용자, 예약 정보 클래스
 *      - 서비스: 사용자, 예약 관련 비즈니스 로직(서로 다른 서비스에서 구현)
 *      - 컨트롤러: 사용자의 요청을 처리하고 응답하는 역할
 *      - 저장소(리포지토리): 데이터 처리에 사용(DAO), DB와 상호작용을 담당
 *
 * 3) 프로젝트 구조
 *      entity: User, Reservation
 *
 *      service (Interface): UserService, ReservationService
 *      service (ImplClass): UserService, ReservationService
 *
 *      controller: ReservationController
 *
 *      repository: UserRepository, ReservationRepository
 *
 */


public class Main {
    public static void main(String[] args) {
        ReservationController controller = new ReservationController();
        controller.run();
    }
}
