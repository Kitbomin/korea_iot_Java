package org.example.chapter14;

/*
 * == 람다식 ==
 * : 함수형 인터페이스(추상 메서드가 하나인)를 간결하게 구현하는 코드식
 * >> 딱 한가지 일을 처리하는 메서드
 *
 * 1. Predicate<T>(판단하다)
 *  : 입력값을 받아 조건을 검사 해 boolean로 반환해줌
 *  : 메서드
 *      - boolean test(T t): 주어진 입력값이 조건을 만족하면 true/ 그렇지 않으면 false
 *      - and (Predicate other), or (Predicate other), negate(): Predicate 조합에 사용
 *   : 형식
 * @FunctionalInterface
 * interface Predicate<T> {
 *      boolean test(T t);
 * }
 *      - negate: 부정하다(현재의 결과를 역전 -> Not...?)
 *
 *
 * 2. Function<T,R>(변환하다)
 *  : 입력값을 받아 특정 연산을 수행한 후 결과 (R)을 반환
 *  : 메서드
 *      - R apply(T t) : 입력값을 받아 변환한 값을 다시 반환 T -> R
 *      - andThen(Function after) : 현재 결과를 다른 Function 입력으로 연결
 *      - Compose(Function before) : 다른 Function의 결과를 현재 입력으로 연결
 *  : 형식
 * @FunctionalInterface
 * interface Function<T,R> {
 *      R apply(T t);
 * }
 *
 *
 * 3. Consumer<T> (소비하다)
 *  : 입력값을 받아 소비(출력 또는 상태 변경)하는 데 사용
 *  : 메서드
 *      - void accept(T t): 입력값을 소비
 *      - andThen(Consumer after): 연속적인 소비작업을 위해 사용
 *  : 형식
 * @FunctionalInterface
 * interface Consumer<T> {
 *      void accept(T t);
 * }
 *
 *
 * 4. Supplier<T> (공급하다)
 *  : 값을 공급(생성) 하는 데 사용, 입력값이 필요 하지 않음
 *  : 입력값이 없는데 어떻게? -> 외부에서 값을 가져오거나, 데이터를 생성해 반환하는 역할을 담당
 *  : 메서드
 *      - T get(): 반환
 *  : 형식
 * @FunctionalInterface
 * interface Supplier<Y> {
 *      T get();
 * }
 */

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class E_Lambda {
    public static void main(String[] args) {
        // 1. Predicate

        System.out.println(" == 1. Predicate == ");
        Predicate<Integer> isEven = n -> n%2 == 0;
        Predicate<Integer> isPositive = n -> n>0;

        System.out.println(isEven.test(11));
        System.out.println(isPositive.test(10));

        //논리값에 대한 연산을 and, or, negate 로 가능
        //: 논리연산자 처럼 조건을 연결해줌
        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive); //and 연산식
        System.out.println(isEvenAndPositive.test(4));
        System.out.println(isEvenAndPositive.test(-4));

        ///  이단이다아아앙랄

        // 2. Function<T,R>

        System.out.println(" == 2. Function == ");
        
        //매개변수(문자열 1개) -반환값(문자열의 길이값 1개) -> 소괄호 중괄호 필요 없음
        Function<String, Integer> stringLength = s -> s.length();
        Function<Integer, Integer> square = n -> n * n;
        Function<String, String> upperString = s -> s.toUpperCase();

        System.out.println(stringLength.apply("이도경 메롱"));
        System.out.println(upperString.apply("nice meet u"));

        // stringLength를 square에 넣어보기
        Function<String, Integer> lengthAndSquare = stringLength.andThen(square);
        //: 문자열의 길이(숫자) 값을 인자로 받아 제곱
        System.out.println(lengthAndSquare.apply("이 문자열 길이의 제곱값은?"));

        // 3. Consumer<T>
        System.out.println(" == 3. Consumer == ");
        Consumer<String> printMessage = msg -> System.out.println(msg);
        Consumer<String> printLength = msg -> System.out.println(msg.length());

        printMessage.accept("안녕하세요 :)");
        printLength.accept("1234567");

        Consumer<String> combinedConsumer = printMessage.andThen(printLength);
        combinedConsumer.accept("123");

        // 4. Supplier<T>
        System.out.println(" === 4. Supplier === ");
        // Math.random(): 0.0 ~ 1.0 사이의 무작위 실수를 반환해줌
        Supplier<Double> randomValue = () -> Math.random();
//        Supplier<Double> random = () -> {return Math.random();};
        // 위의 두 코드는 같은 코드임

        System.out.println(randomValue.get());

    }
}
