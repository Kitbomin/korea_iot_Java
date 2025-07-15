package org.example.chapter13;

import java.util.ArrayList;
import java.util.List;

/**
 * === 제네릭 ===
 * : 다양한 데이터 타입을 처리할 수 있는 코드의 틀
 *
 * +) 자바 표준 라이브러리도 제네릭 기반인게 많음
 *    - ArrayList<T>: 리스트 자료형
 *    - HashMap<K,V>: 키- 값 쌍 자료형
 *    - Optional<T>: 값이 있을 수도 없을 수도 있는 객체 래퍼
 * */

class Basket<T> {
    private T item;

    public void setItem(T item){
        this.item = item;
    }

    public T getItem() {return item;}
}

// === 제네릭의 와일드 카드 === //
// : 제네릭 타입을 사용할 때 정확한 타입을 모를 경우 사용하는 특수 기호
// - 주로 '상속관계' 에 있는 클래스 간의 유연한 타입 처리를 위해 사용
// >> 물음표(?) 기호를 사용해 표기
//    : 타입이 무엇이든 상관 없음을 의미
class Message<T> {
    private T message;
    T getMessage () {return message;}
}



public class B_Generic {
    public static void main(String[] args) {
        Basket<String> stringBasket = new Basket<>(); //글자를 담는 바구니
        stringBasket.setItem("사과");
        System.out.println(stringBasket.getItem());

        Basket<Integer> integerBasket = new Basket<>();//숫자를 담는 바구니
        integerBasket.setItem(777);
        System.out.println(integerBasket.getItem());


        // == 1) 기본 와일드 카드 <?> == //
        // : 모든 타입이 지정 가능한 클래스 타입
        // >> 최상위 클래스의 Object 타입 사용
        Message<?> m1; //모든 타입의 Message 객체를 수용
        // = Message<Object> m1;

        Message<String> m2;

        //형 변환: Object 클래스는 모든 참조 타입의 최상위 클래스
        //      - 모든 타입의 클래스와 상속관계에 있음

        m1 = new Message<>();
        String s = (String) m1.getMessage(); //명시적 형 변환/ 강제형변환
        Boolean b = (Boolean) m1.getMessage();
        Character c = (Character) m1.getMessage();


        // == 2) 일반 와일드 카드 (사용 권장 x) == //
        // ?: 어떤 타입이든 허용
        // >> 와일드 카드의 구조체에 값을 할당하는 경우 -> 불가능
        // >> 값을 꺼내올 수 있음

        List<?> list1 = new ArrayList<>();
//        list1.add("안녕"); => 타입의 불분명성으로 타입 추가 불가능 -> 와일드 카드의 구조체에 값을 할당하는 것이 불가
        list1.add(null); // => Object 값에는 반드시 null 값이 허용됨



        // == 3) 제한된 와일드 카드 == //

        // 3-1) 상한 제한 와일드 카드
        // <? extends Type>
        // : 특정 타입 혹은 그 하위 타입만 허용

        //Number: 숫자의 Wrapper 타입의 상위 클래스(Integer, Double, Float ... => Number의 자손임)
        List<? extends Number> numberList = new ArrayList<>();
        // : Number의 자손 타입 중 하나이지만, 정확히 어떤 타입인지 확인이 불가
        // >> 읽기는 가능, 쓰기는 제한됨
        Number num = numberList.get(0); // -> 이렇게 읽어오는건 가능함
//        numberList.add(10); -> 컴파일 에러 발생, 구체적인 숫자값 추론 불가능(타입 안정성 보장 불가)

        // *내생각* -> Number는 숫자 래퍼 타입의 상위클래스임 -> 그래서 그 아래의 타입만 쓸 수 있는거임 -> Number 보다 더 높이 못올라감


        // 3-2) 하한 제한 와일드 카드
        // <? super Type>
        // : 특정 타입 또는 그 상위 타입만 허용

        List<? super Integer> integerList = new ArrayList<>();
        // >> Integer(정수), 정수가 담길 수 있는 상위타입 허용(Integer, Number, Object)
        integerList.add(123);
        integerList.add(777);
//        integerList.add(123.456); -> Double 은 Integer 안에 포함되어있지 않음
        // +) List<? super Integer>의 의미
        //      : 이 리스트는 Integer의  상위 타입 중 하나로 선언된 리스트임
        //      >> 컴파일러 입장에서는 해당 타입의 객체가 List<Integer>인지, List<Number>, List<Object>인지 알 수 없다.
        //      +) Double 은 Integer의 하위타입도 아니고 상위타입도 아님
        //         >> 얘네들은 일종의 형제관계

        // Integer와 호환되는 값: Integer, int, null 까지가 마지노선

        //만약 Double도 포함시키고 싶다면?
        List<Number> numbers = new ArrayList<>();
        numbers.add(123);
        numbers.add(122.123);
    }

    // 상한 제한 와일드 카드 사용처
    // -> 읽기 전용으로 사용됨(List <Integer>, List<Double>, 등의 인자를 모두 제공받는 메서드
    void printNumbers (List<? extends Number> list) {
        for (Number n: list) {
            System.out.println(n);
        }
    }// 다만, 리스트에 값 추가는 적합하지 않음.
}
