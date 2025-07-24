package org.example.chapter16;

/*
 * === Wrapper ===
 * : 기본 데이터 타입을 객체로 다루기 위해 사용함
 *
 * +) 기본 데이터 타입 -> byte, short, int ,long, char, float, double, boolean (+ void)
 *          >> 각 데이터 타입에 해당하는 Wrapper 클래스가 존재함
 *
 * +) java.lang 패키지에 정의되어있음
 *          : 컬렉션 프레임워크에서는 내부에 객체만을 저장함
 *          - 기본 타입을 Wrapper 클래스로 변환해 저장해야함
 *          >> Integer, Character 등....(이 외에는 시작 알파벳이 대문자임)
 *
 * === Boxing 박싱 & UnBoxing 언박싱 ===
 * : 기본 타입과 해당 타입의 Wrapper 클래스 간의 자동 변환을 의미
 * - 자바의 컴파일러가 자동 처리함
 *
 * 1) 박싱
 *  : 기본 타입 >> Wrapper 클래스의 객체로 변환
 *
 * 2) 언박싱
 *  : Wrapper 클래스의 객체 >> 기본 타입 변환
 *
 * +) 장단점
 *    - 장점: 기본 타입과 객체 타입 간의 호환이 용이함(딱히 제약사항이 없어서 똑같은 취급하면서 써도 됨)
 *    - 단점: 객체 생성 과정에서 메모리 사용량이 증가함(박싱, 언박싱 처리 과정에서 컴파일러가 한번 더 일을 하게 되어 성능 저하 우려가 있음)
 *           null 값이 할당될 수 있는 Wrapper 객체를 언박싱 할 경우 NPE(NullPointerException) 발생 위험성이 있음
 *
 */

public class A_Wrapper {
    public static void main(String[] args) {
        // 1) 박싱
        int i = 5;
        Integer iObject = i;
        System.out.println(iObject);

        // 2) 언박싱
        // Wrapper 객체 생성: 객체타입.valueOf(값);
        Integer integerValue = Integer.valueOf(15);
        int iValue = integerValue;
        System.out.println(iValue);

        /*
         * === Wrapper 클래스의 내부 메서드 ===
         *  - toString() 메서드 등
         */



        // 1) intValue(): Integer 객체를 기본 int 타입으로 변환
        Integer myInteger = Integer.valueOf(20);
        int myInt = myInteger.intValue();
        System.out.println(myInt);

        Object obj = Integer.valueOf(100);
//        int x = obj; - 자동 언박싱 불가 -> 컴파일 에러 발생
        int x = ((Integer) obj).intValue(); // 굳이굳이 언박싱을 해주면 이렇게

        Integer a = null;
//        int abc = a.intValue(); => .NullPointerException
        int abc = (a != null) ? a.intValue() : 0; //안전하게 기본 값 처리
        System.out.println(abc);


        // 2) parseInt(String s): 문자열을 기본 int 타입으로 파싱하는 것
        // String >> Integer >> int
        int parseIntValue = Integer.parseInt("123");
        System.out.println(parseIntValue);

//        int parseIntValue2 = Integer.parseInt("abc"); 숫자로 바꿀 수 없는걸 제공하니까 아래같은 오류가 남
//        System.out.println(parseIntValue2);NumberFormatException: For input string: "abc"


        // 3) a.compareTo(Integer anotherInt)
        //  : 두 Integer 객체를 비교해서 같으면 0, 호출 객체(a)가 더 크면 양수, 더 작으면 음수를 반환함
        Integer anotherInt = Integer.valueOf(200);
        int result = myInteger.compareTo(anotherInt); // myInteger = 20, anotherInt = 200, -> myInteger가 another보다 작아서 음수가 뜸.
        System.out.println(result); // -1



    }
}
