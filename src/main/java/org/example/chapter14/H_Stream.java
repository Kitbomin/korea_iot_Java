package org.example.chapter14;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * === 스트림(Stream, 흐름) API ===
 * : 자바 8버전부터 도입된 기능
 * : 컬렉션 또는 배열에 저장된 데이터를 선언형(직관적이고, 간결함) 방식으로 처리할 수 있게 지원하는 도구
 *
 * - 데이터 필터링, 매핑, 변환, 집계 등의 다양한 작업 수행
 * - 람다식과 결합해 가독성 높은 코드 작성이 가능함 => 함수형 프로그래밍 기법과 함께 씀
 *
 * 1. 스트림의 3단계 구조(데이터 파이프라인)
 *  : 스트림은 데이터를 소스로부터 연속적으로 처리하는 '파이프라인'을 구축
 *
 *  +) 데이터 파이프 라인: 데이터를 사용하는 단계, 절차, 흐름
 *
 *  1) 소스(Source)
 *    : 스트림의 시작점(생성 단계)
 *    - 컬렉션(리스트라던가, 맵이라던가, 셋이라던가...), 배열 또는 파일을 소스로 사용
 *    ex) list.stream(), Arrays.stream() ...
 *
 *  2) 중간 연산
 *    : 데이터를 가공하는 단계(필터링, 매핑(변환), 통계 등)
 *    - 스트림으로 결과가 반환되기 때문에 메서드 체이닝(연쇄작용)이 가능함
 *    - 지연처리 가능: 최종 연산이 실행되기 전 까지 동작하지 않음(결과가 곧이 곧대로 반환되지 않음)
 *    ex) .filter(x -> x % 2 == 0) -> .map(x -> x * x) -> .sorted() || 필터링, 변환, 정렬
 *
 *  3) 최종 연산
 *    : 스트림을 소모하고 결과를 생성해냄
 *    - 모든 데이터를 처리한 후 결과를 반환하거나, 출력하는 연산이 가능함
 *    - 이후(최종연산이 끝나고 나면) 스트림 재사용이 불가능함 (내생각: 일회성인가.. 파이프 라인이 끝났으니까 역행같은건 불가능하다고 봐야햐ㅏㅁ)
 *    ex) collect, forEach, count ...
 *
 *
 * 2. Stream API 특징
 *  1) 불변성   : 원본 데이터를 변경하지 않음, 새로운 값을 반환해줌
 *  2) 지연처리 : 중간 연산은 실제로 실행되지 않고, 최종 연산 시 처리됨
 *  3) 일회성   : 스트림은 한번만 사용 가능(재사용 시 예외 발생)
 *  4) 선언형   : 간결한 문법 사용가능(람다식)
 */



public class H_Stream {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("정지훈");
        names.add("정은혜 :) ");
        names.add("최광섭");
        names.add("손태경 :) ");
        names.add("박진영");
        names.add("박진영");

        System.out.println(names);

        // 1. 데이터 소스화(Stream 생성)
        // 형식 : 데이터.stream()
        Stream<String> streamNames = names.stream();

        // 2. 중간 연산
        // 형식 : 스트림데이터.키워드(람다식)
        //      >> 스트림 소스에 원하는 기능을 사용할 수 있음
        //      >> 핵심은 전체 스트림을 순회해 각 키워드의 기능을 수행할 수 있어야함.

        // +) 스트림 중간 연산 내부의 람다식
        //      >> 스트림 내부의 요소값을 하나씩 매개 변수에 담음
        //      >> 구현부에서 인자로 해당 매개변수와 일치하는 값을 전달하는 경우에는 메서드 참조도 사용가능

        // 자주 사용하는 중간 연산
        // - filter: 조건에 맞는 요소만 추출
        // - map: 요소를 다른값으로 변환(매핑)
        // - sorted: 요소 정렬
        // - distinct: 중복 제거
        // - limit(n): 처음부터 n개만 추출
        // - skip(n): 처음부터 n개를 건너뜀

//        streamNames.filter(name -> name.length() >= 3); //name을 들고와서 name의 길이가 3이상인걸 필터링해줘라
//        streamNames.filter(name -> name + "님"); // 뒤에 님붙이기


        // 3. 최종 연산
        //  : 스트림 소모 + 결과 생성
        // 종류
        // - forEach: 각 요소에 대해 동작 수행(반환값이 없음)
        // - collect: 컬렉션으로 반환할 때 사용
        // - reduce: 모든 요소를 하나의 값으로 줄임
        // - count: 요소의 개수를 반환


        // == 예제 == //

        // 1) "정"으로 시작하는 사람의 이름에 "님" 을 붙여서 출력
        System.out.println(names + "\n");
        streamNames
                .filter(name -> name.startsWith("정"))
                // 문자열.startWith("문자열") -> 해당 문자열로 시작여부를 boolean 으로 반환해줌
                // 문자열.contains("문자열") -> 해당 문자열 포함 여부를 boolean 으로 반환해줌
                .map(name -> name + "님")
//              .forEach(name -> System.out.println(name));
                .forEach(System.out::println); //위에 구문이 이렇게 바뀜 -> 왜냐면 sout.도 결국엔 메서드 참조니까
        System.out.println();
        

        // 2) 길이가 3글자인 사람만 출력
        System.out.println(names + "\n");
        names.stream()
                .filter(name -> name.length() == 3)
                .forEach(System.out::println);
        System.out.println();


        // 3) 중복 제거 후 오름차순 정렬 출력
        System.out.println(names + "\n");
        names.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        
        // 4) 총 인원 수 출력
        System.out.println(names + "\n");
        long count = names.stream()
                .count();
        System.out.println("총 인원수: " +count); //중복이 포함되어있음 없애고 싶으면 distinct 사용
        System.out.println();


        // 5) 이름 중 2번째 인덱스 이후 사람 2명만 출력
        System.out.println(names + "\n");
        names.stream()
                .skip(2)
                .limit(2)
                .forEach(System.out::println);
        System.out.println();


        // 6) 이름 길이의 합 구하기
        System.out.println(names + "\n");
        int totalLength = names.stream()
                .map(name -> name.length())
                .reduce(0, Integer::sum);
                //.reduce(초기값, 합산식);
                //.reduce(0,(a,b) -> a+b )); -> a는 최신값(누적), b는 순회값 => a 에다가 b를 계속 더해대는거
        System.out.println("이름길이 합산: " +totalLength);
        System.out.println();


        // 7) 모든 이름을 하나의 문자열로 합치기(comma)로 구분
        System.out.println(names + "\n");
        String result = names.stream()
                .collect(Collectors.joining("&")); //delimiter = 구분자 
        System.out.println("합친 이름들: " + result);
        System.out.println();

        
        // 8) 이름 길이 기준 내림차순 정렬
        System.out.println(names + "\n");
        System.out.println("오름차순");
        names.stream()
                .sorted() //오름차순 정렬(기본값) => sorted((a,b) -> a.length - b.length())가 생략되어있음
                .forEach(System.out::println);
        System.out.println();

        System.out.println("내림차순");
        names.stream()
                // 내림차순 -> 숫자가 큰 순서대로 정렬
                // a, b는 리스트 안의 두 문자열 : b.length - a.length => 문자열 길이 차이를 이용해 정렬 순서 결정
                // >> b가 더 크면 양수 -> 더 큰 값을 앞으로 정렬(양수면 자리바꿈이 일어나고, 음수면 a가 먼저 정렬, 0이면 그대로)
                .sorted((a,b) -> b.length() - a.length()) //내림차순 정렬
                .forEach(System.out::println);
        System.out.println();


        // 9) 이름을 길이로 그룹화
        System.out.println(names + "\n");
        Map<Integer, List<String>> grouped = names.stream()
//              .collect(Collectors.groupingBy(x -> x.length()));
                .collect(Collectors
                        .groupingBy(String::length));

        grouped.forEach((length, group) -> {
            System.out.println(length + "글자: " + group);
        });
    }
}
