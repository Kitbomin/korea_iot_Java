package org.example.chapter09_pracice.util;

/*
    날짜 및 시간을 포맷팅 하거나 파싱하는 유틸리티 클래스
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    //사용할 날짜 및 시간 포맷패턴 정의
    private static final String PATTERN = "yyyy-MM-dd H:mm:ss";

    //위의 패턴을 기반으로하는 포맷터
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    //위에꺼를 외부로 꺼낼 수 있는 메서드
    //현재 시간을 포맷된 문자열로 반환 시킬거임 -> @return 현재시간
    public static String now() {
        //원하는 날짜시간데이터.format(포맷터);
        return LocalDateTime.now().format((FORMATTER));
    }

    // 전달 받은 LocalDateTime 객체를 포맷 문자열로 변환
    // -> @param datetime 포맷할 LocalDateTime 객체
    // -> @return 포맷된 날짜 문자열
    public static String format(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER);
    }


    // 문자열 형태의 날짜를 LocalDateTime 객체로 파싱
    // -> @param datetimeStr 포맷에 맞는 날짜 문자열
    // -> @return LocalDateTime..
    public static LocalDateTime parse(String datetimeStr) {
        return LocalDateTime.parse(datetimeStr, FORMATTER);
    }

    /**
     * 전달받은 LocalDateTime 객체를 포맷 문자열로 변환
     * @param datetime 포맷할 LocalDateTime 객체
     * @return 포맷된 날짜 문자열
     * */
    public static String format(LocalDateTime datetime) {
        return datetime.format(FORMATTER);
    }

    /**
     * 문자열 형태의 날짜를 LocalDateTime 객체로 파싱
     * @param datetimeStr 포맷에 맞는 날짜 문자열
     * @return LocalDateTime 객체
     * */
    public static LocalDateTime parse(String datetimeStr) {
        return LocalDateTime.parse(datetimeStr, FORMATTER);
    }
}
