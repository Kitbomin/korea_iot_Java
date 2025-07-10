package org.example.chapter09;

// Java.time 패키지
// ISO-8601 표준을 기반으로 설계 되어있음
// : YYYY - MM - DDThh:mm:ss:sssZ 형식
// - import 문을 사용해 클래스를 명시하게 됨


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JavaTime {
    public static void main(String[] args) {

        //1. 날짜
        LocalDate today = LocalDate.now(); //날짜를 출력함
        //now () : 현재 날짜 반환

        System.out.println(today);

        LocalDate yesterday = LocalDate.of(2025, 7, 8); //년도, 월, 일 을 제공시 of()가 국제 표기법 상 표현으로 반환해줌
        System.out.println(yesterday);

        LocalDate tommorow = today.plusDays(1);
        LocalDate onMonthAgo = today.minusMonths(1);
        //.plus(년도, 달, 날) : N년후, N달후, N일 후
        //.minus(동일) : N년 전, N년 후, N일 전
        System.out.println(tommorow);
        System.out.println(onMonthAgo);

        //2. 시간
        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime lunchTime = LocalTime.of(12,50); //of (시, 분, 초..) 가능
        System.out.println(lunchTime);

        //.plus(시, 분, 초...)
        //.minus(시,분,초...)

        //3. 날짜 & 시간
        // .now(), .of, .plus ~, .minus~
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println(nowDateTime);

        // +) get메서드: getYear(), getMonth(), getDayOfMonth(): 날짜 정보 반환
        //              get시간, get분, get초...

        System.out.println(today.getYear());
        System.out.println(today.getMonth()); //키워드가 반환됨(달 영어이름)
        System.out.println(today.getDayOfMonth());

        // 날짜/시간 포맷팅
        // formatting - 원하는 형식으로 출력하는 방법

        LocalDateTime example = LocalDateTime.now();
        System.out.println(example);

        //DateTimeFormatter: LocalDateTime 의 날짜/시간 데이터를 원하는 패턴으로 변경
        // .ofPatter에 원하고자 하는 패턴을 문자열로 전달할거임

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss"); //이게 머꼬... SQL의 악몽이 떠오른다

        //변경할 날짜/ 시간 데이터.format(원하는 포맷 형식);
        System.out.println(example.format(formatter));
    }

}
