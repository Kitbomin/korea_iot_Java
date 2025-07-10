package org.example.chapter03;

public class B_Array {
    public static void main(String[] args) {
        // == 배열의 순회 == //
        //
        int[] scores = {85,100,90,75,90};
        System.out.println(" === 인덱스 번호로 출력 === ");

        System.out.println(scores[0]);
//        System.out.println(scores[1]);
        System.out.println(scores[2]);
        System.out.println(scores[3]);

        //1) for 문을 사용해 순서대로 출력하는 방법
        // for의 초기화 변수를 인덱스 번호처럼 사용 가능

        System.out.println("=== for 문 사용 ===");
        // 더 나은 성능향상
        int scorelen = scores.length;

        for (int i = 0; i < scorelen; i++) {
            System.out.println(scores[i]);
        }
        //2) 향상된 for문 (for each)
        // 배열을 순회(탐색)하는 방법
        // for문이 경량화된 버전
        /*
            for (데이터타입 변수명 : 해당 데이터타입의 배열) {
                    배열의 각 요소를 활용하는 코드
            }
         */

        System.out.println(" === 향상된 for, for-each문 ===");

        for (int score: scores) {
            // score 변수:  for문의 반복에서 배열의 요소를 순차적으로 담는 변수

            System.out.println(score);

        }

        // 배열 예제 //

        System.out.println("배열 예제");
        // 학생 점수의 평균을 계산
        // 점수를 모두 더해서 점수의 개수만큼 나누면 됨

        int total = 0;
        double avg;
        //1) 일반 for문
        for (int i = 0; i < scorelen; i++){
            total += scores[i];
        }
        System.out.println(total);



        //2) for each
        total = 0;
        for(int score: scores) {
            total += score;
        }

        System.out.println(total);
        avg = (double) total / scorelen;
        System.out.println(avg);


    }
}
