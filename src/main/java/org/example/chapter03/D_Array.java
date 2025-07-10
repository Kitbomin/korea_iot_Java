package org.example.chapter03;

// Array => 배열 => 데이터타입이 같은 값들이 순차적으로 저장되는 자료 구조의 일종
// Arrays 라는 클래스가 존재함 => 배열을 조작하는데 유용한 기능들을 제공해주는 자바 내부 클래스
//      >>>java.util 내에 존재
//      >>정렬, 검색, 변환 등등 다양한 기능이 있음

import java.util.Arrays;

public class D_Array {
    public static void main(String[] args) {
        // === Arrays 클래스 사용법 === //

        //자바의 배열 자료형에서만 동작함 => 일반 배열만 사용할 수 있음
        // >>> 동적배열 arraylist 에서는 사용 불가능함. 얘는 Collections 클래스를 사용함

        int[] numbers = {3,5,1,4,2};

        //1. 배열 정렬 (오름차순)
        Arrays.sort(numbers);

        System.out.println(numbers[0]);

        //2. 배열 변환(출력/배열 내용을 문자열로 출력)
        Arrays.toString(numbers);
        System.out.println(Arrays.toString(numbers));

        //3. 배열 검색 Binary Search(배열, 검색 내용);
        //  배열 내에 존재하면 존재하는 요소으 ㅣ인덱스 번호를 반환, 존재하지 않으면 해당 검색 값의 음수를 반환

        System.out.println(Arrays.binarySearch(numbers, 2));
        System.out.println(Arrays.binarySearch(numbers, 6));

        //주의점 => binarysearch()는 이진탐색 기법을 사용. => 정렬되어있어야 탐색 가능 => 배열 정렬하고 쓸 것.

        //4. 배열 비교 Arrays.equals(a배열, b배열)
        //논리값으로 반환됨
        int[] numbers2 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.equals(numbers, numbers2));

        //5. 배열 채움(모든 요소를 특정 값으로 초기화)
        //Arrays.fill(배열, 삽잉ㅂ할 값);

        int[] examples = new int[3];
        System.out.println(Arrays.toString(examples));

        Arrays.fill(examples, 10);
        System.out.println(Arrays.toString(examples));
//
//        int[][] matrix2 = {{1,4,2}, {6,5,3}, {8,9,7}};
//        Arrays.sort(matrix2);
//        System.out.println(Arrays.deepToString(matrix2));

    }
}
