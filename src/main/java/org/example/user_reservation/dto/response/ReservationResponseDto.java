package org.example.user_reservation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ReservationResponseDto {
    private Long reservationId;
    private String userId;
    private Date reservationTime;
    private String activeMessage;
}
