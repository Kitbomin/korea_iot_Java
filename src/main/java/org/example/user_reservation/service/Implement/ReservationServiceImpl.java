package org.example.user_reservation.service.Implement;

import org.example.user_reservation.dto.response.ReservationResponseDto;
import org.example.user_reservation.service.ReservationService;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    @Override
    public void createReservation(String userId) {

    }

    @Override
    public List<ReservationResponseDto> getReservationByUserId(String userId) {
        return List.of();
    }

    @Override
    public void cancelReservation(Long reservationId) {

    }
}
