package org.example.chapter03;

import java.util.ArrayList;

public class F_Practice {
    public static void main(String[] args) {
        /*
            1. 크기가 10인 ArrayList생성
            2. 1~10까지의 숫자를 차례대로 추가
            => 반복문으로 추가?

            3. 전체 리스트 출력(원본 리스트)

            4. 원본 리스트에서 홀수만 제거하고 결과를 출력 (반복문, 조건문)
            => 배열 한번 싹 돌면서 홀수 값일 경우 제거 => 계속 순회

            5. index 3번에 값 50을 삽입한 뒤 결과 출력

         */

        ArrayList<Integer> list = new ArrayList<>(10);

        for (int i = 1; i < 10; i++) {
            list.add(i + 1);
        }

        System.out.println(list);

        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) % 2 != 0) {
                list.remove(j);
                j--; //인덱스 번호 조정 => ArrLst는 크기가 동적으로 변하기때문.
                //인덱스 조정하지 않으면 정상 동작되지 않는 경우
                // => 연속된 요소를 제거할 때
            }
        }
        System.out.println(list);

        list.add(3, 50);

        System.out.println(list);
        // 존재하지 않는 인덱스에 접근하면 예외발생 => 예외처리 필요



    }
}
