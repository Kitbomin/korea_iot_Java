package org.example.user_reservation.repository;

import org.example.user_reservation.entity.Reservation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReservationRepository {
    // 저장소
    private final List<Reservation> reservations = new ArrayList<>();

    // 예약 등록, 조회, 취소

    // 등록: Create
    // : DB에 새로운 예약을 저장해야함
    // +) 요청값 = 예약 정보 | 응답값 = X

    public void save(Reservation reservation) {
        reservations.add(reservation);
    }


    // 조회: Read
    // : 단건 예약에 대한 조회 (reservationId 사용 => 해당 예약건의 고유값)
    // +) 요청값 = 예약 고유번호 | 응답값 = 예약 정보
    public Optional<Reservation> findById(Long reservationId) {
        return reservations.stream()
                .filter(res -> res.getReservationId().equals(reservationId))
                .findFirst(); // 검색된 조건의 일치하는 요소 중 첫번째 요소를 Optional 자체로 반환
    }


    // : 전체 예약자 정보와 일치하는 예약을 조회(userId 사용)
    // +) 요청값 = 사용자 Id | 응답값 = 예약 정보 리스트
    public List<Reservation> findByUserId(String userId) {
        return reservations.stream()
                // 해당 예약자의 리스트 중 예약이 유효한 목록만 확인
                .filter(res -> res.getUserId().equals(userId) && res.isActive())
                .collect(Collectors.toList());

    }

    //(현재 프로젝트에서는 DB 없이 객체 내부의 상태만 변경) -> DB 와의 소통은 없음 -> 취소 자체의 로직은 없음

    // 취소: Update
    // +) 요청값 = 사용자 Id | 응답값 = 예약 정보 리스트
    // ㄴ 취소를 준비하기 위한 데이터 정제과정






}
