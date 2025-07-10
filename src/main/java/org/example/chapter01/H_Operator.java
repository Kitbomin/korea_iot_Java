package org.example.chapter01;

public class H_Operator {
    public static void main(String[] args) {
        // === 연산자 (Operation) === //

        // 프로그램 내에서 데이터를 조작하거나 계산하는 것

        System.out.println("==산술 연산자==");
        // 사칙연산 (덧셈, 뺄샘, 곱셈, 나눗셈)

        int a = 10; int b = 20;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b); // 몫을 반환
        System.out.println(a % b); // 나머지를 반환 ★★★★★


        System.out.println("==증감 연산자==");
        //변수의 값을 1 증가시키거나 1감소 시키는 연산자
        int num = 10;

        // 1) 전위 증감 연산자 => 값이 먼저 변경되고 나서 계산에 적용
        System.out.println(++num); //11 => 10 + 1 증가 후 출력
        System.out.println(--num); //10 => 11 - 1 감소 후 출력

        // 2) 후위 증감 연산자 => 값이 계산된 이후 변경
        System.out.println(num++); //10 => 출력 후 +1 증가
        System.out.println(num--); //11 => 출력 후 -1 감소

        System.out.println(num);//최종적인 num 값


        num++; //10
        num++; //11
        ++num; //13
        --num; //12
        num--; //12
        num++; //11
        System.out.println(num); //12

        System.out.println("== 대입 연산자 ==");
        //변수에 값을 할당할 때 사용하는 연산자
        // 기본 연산자(=), 사칙연산과 결합된 연산(+=, -=, *=, /=, %=)

        num = 10;

        //해당 값의 연산 후 다시 변수에 할당
        System.out.println(num += 3); //num 에 3을 더한 후의 결과를 num에 재할당 => num = num + 3
        System.out.println(num -= 3); //num 에 3을 뺀한 후의 결과를 num에 재할당 => num = num - 3
        System.out.println(num *= 3); //num 에 3을 곱한 후의 결과를 num에 재할당 => num = num * 3
        System.out.println(num /= 3); //num 에 3을 나눈한 후의 결과를 num에 재할당 => num = num / 3
        System.out.println(num %= 3); //num 에 3을 몫의 결과를 num에 재할당 => num = num % 3

        System.out.println(num);

        System.out.println("== 비교 연산자 ==");
        // 좌항과 우항을 비교한 결과를 논리 값으로 반환하는 연산자(<,>,<=,>=,==,!=)

        System.out.println(5 > 3);
        System.out.println(5 >= 3);
        System.out.println(5 < 3);
        System.out.println(5 <= 3);
        System.out.println(5 == 3);
        System.out.println(5 != 3);


        System.out.println("== 논리 연산자 ==");
        //논리값을 연산
        //AND, OR, NOT, XOR
        //&(앰퍼센드), |(bertical var)

        //1) 논리곱(and, &&) => 모든 값이 true 여야만 true의 결과를 나타냄. 단 하나의 값이라도 false면 false의 값 반환

        System.out.println(true && true && true);
        System.out.println(true && true && true && false && true && true);

        //2) 논리합(or, ||) => 하나의 값이라도 true면, true의 값을 반환. 단 모든 값이 false인 경우 false 반환
        System.out.println(true || true);
        System.out.println(true || true || false || false || false);
        System.out.println(false || false || false);

        //3) 부정논리 (not, !)
        // 논리값을 전환 => 논리값 앞에 ! 키워드를 사용해 작성

        boolean bool1 = true;
        boolean bool2 = false;

        System.out.println(!bool1);
        System.out.println(!bool2);

        System.out.println(3 > 2 && 1 == 1);
        System.out.println(1 != 1);
        System.out.println(3 >= 3 || 10 < 11 && !bool2);

        System.out.println("== 조건 삼항 연산자 ==");
        // 조건식(논리의 값이 반환) ? 조건식이 참인 경우의 값 : 조건식이 거짓인 경우의 값;

        int age = 10;
        String drink = age > 19 ? "맥주" : "오렌지 주스";
        System.out.println(drink + "을(를) 마십니다");
        
        int x = 10, y =2;
        System.out.println(x % y == 0 ? "2의 배수입니다" : "2의 배수가 아닙니다");


        System.out.println("== 기타 연산자 ==");
        //문자열 연결 연산자 +
        String result = "이" + "승아";
        System.out.println(result);

        //연산자의 우선순위
        // 기본 => 좌측 -> 우측
        //      그러나 대입연산자의 경우 우항 -> 좌항으로의 대입
        //      ()괄호 연산자의 경우 우선순위를 가짐

    }
}
