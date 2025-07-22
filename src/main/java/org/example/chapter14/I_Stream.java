package org.example.chapter14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class I_Stream {
    public static void main(String[] args) {

        //Arrays.asList => 일반 배열을 ArrayList로 반환해줌
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        List<Integer> newNumbers =
                numbers.stream()
                        .map(n -> n *n)
                        .collect(Collectors.toList()); // => 리스트로 변환됨 // 최종연산 - 변경 가능한 리스트를 반환(mutable list) /Java 8버전 이상


        newNumbers.add(10);


        // .stream() 으로 생성된 스트림은 일회성으로만 사용 가능함
        // - 메서드 체이닝으로 여러 기능을 적용하는건 가능하지만, 이걸 여러번 사용하는건 안됨
        Stream<Integer> stream = newNumbers.stream();

        List<Integer> a = stream
                        .map(n -> n*n)
                        .toList(); //최종연산 - 불변리스트를 반환(immutable list) / Java 16 이상

        //UnsupportedOperationException 오류발생
//        a.add(100);

//        stream.filter(n -> n % 2 == 0).toList(); => 주석처리하면 아래 오류 없어짐
        // IllegalStateException: stream has already been operated upon or closed => 스트림 재사용시 발생하는 오류

        System.out.println(numbers);
        System.out.println(newNumbers);

    }
}
