package org.example.z_project.phr_solution.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /*
     * 문자열 날짜가 yyyy-MM-dd 형식에 맞는지 검증
     * : 형식에 맞으면 true, 아니면 false
     */
    private static boolean isValid(String dateString) {
        try {
            LocalDate.parse(dateString, formatter);
            return true;

        }catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * 문자열 날짜가 yyyy-MM-dd 형식에 맞지 않으면 예외 발생
     * 유효하면 반환
     */
    public static void validateOrThrow(String dateString) {
        // 예외가 발생하지 않았다면 입증이 되었다는 얘기
        if (!isValid(dateString)){
            //형식에 맞지 않다면
            throw new IllegalArgumentException("날짜 형식이 올바르지 않아요. (yyyy-MM-dd)");
        }
    }

}
