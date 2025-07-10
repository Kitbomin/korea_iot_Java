package org.example.chapter09;

// 2. throw, throws 키워드

/*
   == throw. throws ==

   1. throw
    : 프로그램 실행 중에 특정 조건에서 예외를 직접 발생시킬 때 사용함
      > 주로 조건문과 함께 사용되고 프로그램의 흐름을 제어하는 역할을 함

      사용방법
      : throw new ExceptionType("예외 메시지");
      - 인자로 전달하는 문자열은
      - 예외변수 e.getMessage() 메서드를 활용해 catch 블록에서 출력이 가능함

   2. throws
    : 메서드 선언부에 위치, 호출자에게 예외 처리를 위임함
    - 체크(컴파일) 예외: 필수 명시
    - 언체크(런타임) 예외: 선택 명시

      사용방법
      : [접근제어자] 반환타입 메서드명() throws ExceptionType {}


  +) throw : 메서드 내부에 위치, 예외를 발생시킴,


 */


// 3. 사용자 정의 예외 처리
//  : 자바의 Exception 클래스를 '상속' 받는 자식 클래스를 직접 정의함
class InvalidUserException extends Exception {
    InvalidUserException(String message) {
        super(message); // Exception 클래스의 getMessage() 메서드 사용 가능
    }
}

class CustomException extends Exception {
    CustomException(String message) {
        super(message);
    }
}

public class Exception03 {
    // 1) 단일 예외 던지기 - throw
    //  : 메서드 선언부에서 해당 메서드가 발생시킬 수 있는 예외를 명시하는 키워드
    //    - 메서드 호출자에게 예외 처리를 위임시킴

    static void login (String username, String password) throws InvalidUserException {
        //문자열.equals(문자열);
        // : 동일한 문자열일 경우 true, 아니면 false
        if (!"admin".equals(username)) {
            //admin과 일치하지 않는 경우 - 예외발생(사용자 정의 예외)
            //잘못된 사용자인 경우
            throw new InvalidUserException("사용자의 이름이 잘못되었습니다");
            //처리되지 않은 예외: org.example.chapter09.InvalidUserException
        }
    }

    // 2) 여러 예외 던지기 - throws
    //  : throws 키워드에 ,(콤마)로 구분해 나열
    static void exeptions(int num) throws CustomException, ArithmeticException, ArrayIndexOutOfBoundsException {
        if(num == 1) {
            throw new CustomException("1번 선택- 커스텀 예외");
        }else if(num == 2) {
            throw new ArithmeticException("2번 선택- 수학공식 예외");
        }else {
            throw new ArrayIndexOutOfBoundsException("그 외의 예외");
        }
    }

    public static void main(String[] args) {

        int age = -10;

        try {
            if (age < 0) {
                throw new Exception("나이는 음수가 될 수 없습니다.");
            }
            System.out.println("예외 발생 시 실행 안됨");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("기타 실행 상황");

        // == 사용자 정의 예외 처리 == //
        //login("admin", "qwe123");
        try {
            System.out.println("출력 1");
            login("admin", "qwe123");
            System.out.println("출력 2");
            login("qwer", "qwe123");
            System.out.println("출력3");
        }catch (InvalidUserException e) {
            System.out.println(e.getMessage());
        }


        // 여러 예외 던지기 //
//        exeptions(1);
        try {
            System.out.println("여러 예외 던지기 테스트");
            exeptions(2);
        }catch (CustomException e) {
            System.out.println("1번: " + e.getMessage());
        }catch (ArithmeticException e) {
            System.out.println("2번: " + e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("기타: " + e.getMessage());
        }
    }
}
