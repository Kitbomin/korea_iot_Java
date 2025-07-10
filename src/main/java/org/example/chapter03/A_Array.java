package org.example.chapter03;

public class A_Array {
    public static void main(String[] args) {
        //배열//
        // 자바에선 "같은 타입"의 여러 변수를 하나의 집합으로 묶어서 처리하는 구조
        // 데이터를 "연속적"으로 저장하게 됨
        // >> 배열은 데이터를 정렬하는 순서가 존재함. => 이걸 구분하려면 인덱스 번호가 있어야함.
        //    >>> index 0부터 시작해 1씩 증가되는 값
        // >> 중복 데이터가 들어가는 것도 가능함. => 동일한 값을 여러 요소에 저장 가능함

        // 요소: 배열에서의 각각의 데이터

        //변수
        //1) 변수를 사용해 각 과목의 성적을 저장

        int Korean = 90; int math = 95; int Eng = 85;
        // 각 학생의 각 과목의 성적을 저장하려면
        /*
        int Korean1 ... Korean n
        int math1 ... math n => 구체적인 정보를 판단하기 어려움
         */

        //배열
        // 사용하고자 하는 공간을 생성하여 사용해야함
        // >>>Scanner 생성과 유사, new 연산자 사용

        // 배열 선언 (좌항) //
        // 생성한  배열을 담을 그릇
        // 1) 데이터 타입[] 배열명; => 대개 이걸 많이 씀
        // 2) 데이터 타입 배열명[];
        int[] scores1;
        //배열 명은 복수 형태의 이름 사용 권장

        // 배열 선언 (우항) //
        // new 데이터타입[배열의 길이];
        scores1 = new int[3]; //요소의 개수가 3개인 배열을 생성

        //System.out.println(scores1);
        // 참조 자료형은 기본적으로 주소값이 저장됨. => 데이터 배열이 저장된 첫번째 메모리 주소가 저장(인덱스 0번의 주소)
        // 배열 요소에 접근하는 방법
        // >> 배열명[인덱스번호]

        scores1[0] = 80;
        scores1[1] = 90;
        scores1[2] = 85;

        // 배열의 요소에 접근해 데이터 변경(삽입)을 할때 쓰임
        System.out.println(scores1[0]);
        System.out.println(scores1[1]);
        System.out.println(scores1[2]);
        //System.out.println(scores1[3]); => Array Index Out Of Bounds  Exception 배열 번호 범위 초과값 오류
        // 배열은 생성시 모든 요소는 해당 데이터 타입의 기본값으로 초기화가 됨.
        // 숫자 = 0, 문자열 = "", 논리형 = false가 기본값임

        // 전체 요소의 개수 -1 == 마지막 인덱스 번호
//        System.out.println(scores1);

        // 1) 배열의 선언: int[] numbers;
        // 2) 배열 생성: numbers = new int[3];
        // 3) 배열의 초기화: 각각의 인덱스 번호를 사용해 데이터를 삽입

        // === 배열의 선언고 ㅏ동시에 초기화 //
        // new 연산자 사용 + 직접적으로 요소를 대입해 배열 생성 시 길이 지정을 하지 않는 방법
        // >> 요소의 개수를 자바가 파악해서 길이 자동 지정
        //1) 데이터타입[] 배열명 = new 데이터타입[] {요소 1, 요소 2, ,,,,};
        int[] number1 = new int[] {1,2,3,4,5};
        System.out.println(number1[0]);

        //2) 데이터타입[] 배열명 = {요소 1, 요소 2, ,,,,};
        char [] greet = {'h', 'e', 'l', 'l', 'o'}; //동일한 데이터 중복저장 ㄱㄴ
        System.out.print(greet[0]);
        System.out.print(greet[1]);
        System.out.print(greet[2]);
        System.out.print(greet[3]);
        System.out.print(greet[4]);

        System.out.println();


        // === 배열의 크기 (길이) 값을 구하는 방법 === //
        // 배열명.length
        System.out.println(greet.length);

        // (변수명 || 데이터타입)에 마침표. 를 사용해 기능을 불러올거임
        //  >>> 해당 데이터 타입 내에 내장된 자바 기능을 활용할거임

        // === 배열의 특징 === //
        // 한번 생성되면 크기 변경이 안됨
        // 참조타입 => 주소값이 저장됨 / 모든 요소는 다 같은 자료형을 가짐


        // 참조 자료형의 출력 //
        // 자바에서 객체를 sout으로 출력할 시 내부적으로 객체를 .toString() 기능을 호출함
        // -> 객체? 모든 참조 자료형의 집합체

        String a = "안녕";
        System.out.println(a);
        System.out.println(a.toString());
        // >> String은 내부적으로 toString() 호출 ㅅ ㅣ실제 데이터값 자체를 반환하도록 설정
        // >> 배열, 객체는 toString()이 주소값을 문자열로 출력시켜줌

        int[] arr1 = {1,2,3};
        char[] arr2 = {'a', 'b', 'c'};
        System.out.println(arr1);
        System.out.println(arr2); //char는 문자열 처럼 자동처리 됨

        //[I@2f92e0f4
        /*
            [ -> 배열
            I -> 배열의 원소타입
            @ -> 구분자
            2f92e0f4 -> 해시코드의 16진수 표현
                        >>> 해시코드: 객체를 식별하는 데 사용되는 정수값
         */

        // == 문자열 배열 생성 == //
        // String 자체를 요소값으로 사용 => 초기값이 null임

        String[] fruits = new String[3];
        System.out.println(fruits);
        System.out.println(fruits[0]);

        fruits[0] = "사과";
        fruits[1] = "오렌지";

        System.out.println(fruits[0]);
        System.out.println(fruits[1]);


        // == 배열 요소 삭제 == //
        // 정적 배열은 삭제 기능을 담당하는 문법이 없음 >>> 삭제할 요소를 제외한 나머지 요소를 새로운 배열로 옮기는걸 할거임
        int [] original = {1,2,3,4}; //길이가 4
        int removeIndex = 2;// 삭제할 요소의 인덱스 번호
        int [] newArr = new int[original.length - 1];
        int k = 0; //새로운 배열의 인덱스 번호

        for (int index = 0; index < original.length; index++) {
            //배열 요소의 길이 만큼 반복
            // for 문 내에서 반복 중 removeIndex와 index 번호가 일치하는 경우 => 해당 인덱스 번호값은 넘어간다

            if (index == removeIndex) {
                continue;
            }
            newArr[k++] = original[index];
            // k, index,
            //newArr[0] = original[0]
            //newArr[1] = original[1]
            //newArr[2] = original[3]
        }
        System.out.println(newArr[0]);
        System.out.println(newArr[1]);
        System.out.println(newArr[2]);



    }
}
