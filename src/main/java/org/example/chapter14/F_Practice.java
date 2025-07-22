package org.example.chapter14;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * === 학생 점수 처리 시스템 ===
 * : 람다식, 주요 함수형 인터페이스 사용
 *
 *
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

        // 함수형 인터페이스 사용
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

        // +) Map.Entry<String, Integer>
        //  : Map 인터페이스 안에 정의된 중첩 인터페이스
        //  - Map의 각 "키-값 쌍" 을 나타내는 객체
        // 예시
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 3);
        //"Apple" => 3(사과는 3개)라는 형식이 map에 저장되어있음 => 이 값이 각 요소를 Map.Entry<String, Integer> 타입으로 다룰 수 있음
        map.put("Banana", 5);



    }
}
