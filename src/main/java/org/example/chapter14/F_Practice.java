package org.example.chapter14;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * === 학생 점수 처리 시스템 ===
 * : 람다식, 주요 함수형 인터페이스 사용
 */

public class F_Practice {
    public static void main(String[] args) {

        // [1] 학생 이름과 점수를 저장할 Map 생성
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("김지선", 90);
        studentScores.put("김동후", 80);
        studentScores.put("권지애", 95);
        studentScores.put("박현우", 85);
        studentScores.put("김승민", 100);

        // ▼ 함수형 인터페이스 사용 ▼

        // [2] Predicate: 점수가 90점 이상인지 판단하는 조건 함수 + 90점 이상이면 true, 따로 담기
        Predicate<Integer> isPass = score -> score >= 90; //score값이 90 이상이 -> isPass에 담기

        // [3] Function: 점수를 학점(등급)으로 변환하는 함수
        Function<Integer, String> gradeFunction = score -> { //gradeFunction에 score 값을 넣어 String 으로 변환
            if (score > 100 || score < 0) return "X";
            else if (score >= 90) return "A";
            else if (score >= 80) return "B";
            else if (score >= 70) return "C";
            else return "F";
        };


        // [4] Consumer: 콘솔에 출력하는 함수

        // 1) 전달받은 문자열 길이만큼 '=' 문자 출력(구분선 용도)
        // 문자열.repeat(int) => ()안의 내용만큼 문자열을 반복해 새로운 문자열을 반환
        Consumer<String> line = s -> System.out.println("=".repeat(s.length()));

        // 2) 제목을 꾸며서 출력하는 함수
        Consumer<String> printHeader = title -> {
            line.accept(title); // 상단 구분선
            System.out.println(title); // 제목 출력
            line.accept(title); // 하단 구분선
        }; // 제목을 위아래로 ===로 감싸서 출력 -> 근데 이제 =는 문자열의 길이만큼

        // 3) 학생 1명 정보를 출력하는 함수(이름, 점수, 등급, 합격여부)
        // Consumer<Map.Entry<String, Integer>> Map의 정보를 들고와서 Consumer에 넣어주기...?
        Consumer<Map.Entry<String, Integer>> printStudentInfo = entry -> {
            String name = entry.getKey();//이름
            int score = entry.getValue();//점수

            String grade = gradeFunction.apply(score); //등급 계산

            boolean pass = isPass.test(score); // 합격 여부 판단

            System.out.println(name + " | 점수: " + score + " | 등급: " + grade + " | " + (pass ? "합격" : "불합격") );

        };

        // [5] Supplier: 무작위 보너스 점수를 생성하는 공급자 함수 | 0~5점 중 하나를 반환
        // Random() 클래스의 .nextInt(N) => 0이상 N 미만의 점수를 반환(0~5)
        Supplier<Integer> bonusSupplier = () -> new Random().nextInt(6);

        // [6] 프로그램 실행 - 제목 출력
        printHeader.accept("학생 점수 처리 결과");

        // [7] Map의 entrySet()을 사용해 전체 학생 처리
        // - entrySet(): 키와 값의 쌍을 순회할 수 있도록 Set<Map.Entry> 형태를 반환
        studentScores.entrySet().forEach(entry -> {
            //무작위 보너스 점수 생성 + 기존 점수에 add
            int bonus = bonusSupplier.get();
            entry.setValue(entry.getValue() + bonus); //value값 들고와서 bonus 더한 다음에 entry set함

            printStudentInfo.accept(entry);
        });


        // +) Map.Entry<String, Integer>
        //  : Map 인터페이스 안에 정의된 중첩 인터페이스
        //  - Map의 각 "키-값 쌍" 을 나타내는 객체
        // 예시
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 3);
        //"Apple" => 3(사과는 3개)라는 형식이 map에 저장되어있음 => 이 값이 각 요소를 Map.Entry<String, Integer> 타입으로 다룰 수 있음
        map.put("Banana", 5);


        /*
         * Predicate<T>(조건판단) : score >= 70 판별
         * Function<T, R> (변환처리) : score -> grade 변환
         * Consumer<T> (값 소비(출력)) : 학생 정보를 출력, 구분선 출력
         * Supplier<T> (값 제공(입력값 없음) : 무작위 보너스 점수 생성
         */

    }
}
