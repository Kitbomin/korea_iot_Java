package org.example.chapter03;

public class C_Array {
    public static void main(String[] args) {
        //다차원 배열
        // 배열의 배열 (배열 내의 요소가 배열이다)
        // 2,3,4,....차 배열
        //>>데이터를 테이블 형태로 구성할 때 주로 사용
        //>> 게임보드, 데이터분석, 그래픽에 유리

        //다차원 배열의 선언 및 초기화

        //2차원 배열 선언: 데이터타입[][] 배열명;
        //2차원 배열의 생성: new 데이터타입[행의 개수][열의 개수];
        int[][] matrix = new int[3][2];

        matrix[0][0] = 1; matrix[0][1] = 2; //matrix[0][2] = 3; => 어레이범위값 벗어난 오류

        //선언과 동시에 초기화하는 방법
        int[][] matrix2 = {{1,2,3}, {4,5,6}, {7,8,9}};

        //다차원 배열 출력
        //  각 행을 순회 + 해당 행 내부으 ㅣ요소를 순회

        for (int[] row: matrix2){
            for (int value: row){
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }
}
