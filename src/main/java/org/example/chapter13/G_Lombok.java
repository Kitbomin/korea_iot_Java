package org.example.chapter13;

/**
 * === 롬복 (LomBok) 라이브러리 ===
 * : 자바에서 반복적으로 작성해야하는 보일러플레이트(boilerplate) 코드를 줄여주는 라이브러리
 * - 어노테이션(코드 주석) 을 사용해 코드를 간결하게 만들어주는 역할을 함
 *
 * 보일러플레이트 코드
 * - 프로그래밍에서 반복되는 작업이나 패턴에 대한 일종의 표준화된 코드
 *
 * 대표적인 보일러 플레이트 코드
 * : getter/setter | toString() | 생성자 | Builder 패턴
 *
 *
 * == 라이브러리 VS 프레임워크 ==
 *  - 서로 제어의 주체가 다름
 *
 * 1) 라이브러리
 *  : 개발자가 만들어낸 클래스들의 나열 (기능의 모음)
 *  - 원하고자 하는 기능을 라이브러리 내에서 추출해 사용 가능
 *    >> 개발자가 라이브러리를 제어 가능함("개발자"가 호출)
 *  ex) Lombok, Gson, React ..
 *
 * 2) 프레임워크
 *  : 개발자가 따라야하는 가이드를 제공(아키텍쳐 제공)
 *    >> 프레임 워크가 개발자를 제어("프레임 워크"가 호출을 함)
 * ex) Spring, Django ..
 * */


/**
 * == 롬복 환경설정 ==
 * 주의 * Java + Gradle 빌드 도구 사용 프로젝트
 *
 * 1) build.gradle 파일에 롬복 추가
 *    +) 메이븐 리포지토리: Java project 에서 필요한 라이브러리(외부코드)들을 쉽게 다운하고 관리할 수 있도록 도와주는 저장소
 *    - 주로 Maven 빌드도구와 함께 사용되지만 Gradle 에서도 사용 가능함
 *
 * 2) gradle 리로드(refresh)
 *
 * 3) 설정(빌드, 실행, 배포 > 컴파일러 > 어노테이션 처리 활성화)
 */

import lombok.*;


/**
 * == 롬복(Lombok) 라이브러리 어노테이션 종류 ==
 *
 * 1. @Getter / Setter
 *  : 필드에 대한 getter와 setter 메서드를 자동 생성
 *
 * 2. @ToString
 *  : 클래스의 toString() 메서드를 자동 구현
 *  - 객체 출력 시 지정된 형식으로 출력
 *  - 클래스명(필드명1 = 필드값1, 필드명2 = 필드값2, ...)
 *
 * 3. 생성자 어노테이션
 * - 매개변수는 parameter(params), 인자(인수), argument(args) 라고 부르기도 함
 *
 * 1) NoArgsConstructor: 인자가 없는 생성자
 * 2) AllArgsConstructor: 모든 필드 값을 인자로 가지는 생성자
 * 3) RequiredArgsConstructor : final , @NonNull 어노테이션이 붙은 필드를 인자로 가지는 생성자
 *
 * 4. Data 어노테이션
 * > @Getter, @Setter, @ToString, @RequiredConstructor, @EqualsAndHashCode
 *   어노테이션을 한번에 적용하는 어노테이션
 *
 * +) @EqualsAndHashCode
 *    : 두 객체의 내용이 같은지(동등성) 비교 & 두 객체가 같은 객체인지(동일성) 비교 연산자
 *     > boolean 반환
 *
 * 5. @Builder
 *  : 복잡한 객체 생성 시 사용하는 빌더 패턴을 자동으로 구현시켜줌
 *  - 필드 값을 모두 메서드 체이닝으로 가져옴 (필수값 또한 메서드 체이닝으로 구성)
 *  - 메서드 체이닝 이름은 필드명
 *    >> 필수값을 페이닝에서 누락 시 오류가 나게끔 함
 */

@Getter
@Setter
@ToString
//@NoArgsConstructor => 인자가 없는데 밑에선 인자를 받고있음
@AllArgsConstructor //title, author, publisher을 다 가지고 있음
@RequiredArgsConstructor // title, author만 가지고 있음
@Builder

class LombokClass{
    private final String title;
    @NonNull
    // null값이 들어갈 수 없음 -> 필드에 필수값 지정
    // +) 값의 변화는 가능하다 => final의 불변성과의 차이점이 있다.
    private String author;

    // @Getter/Setter 메서드는 각 필드의 getter/setter을 모두 생성해줌
    //public String getTitle() {return title;} //필드 'title'은(는) Lombok @Getter를 가질 수 있습니다
    //public void setAuthor(String author) {this.author = author;} //필드 'author'은(는) Lombok @Setter를 가질 수 있습니다

    private String publisher;

//    LombokClass(String title, String author); => final , @NonNull 어노테이션이 붙은 필드를 인자로 가지는 생성자를 이미 위에서 어노테이션으로 불렀는데, 여기서 재정의 하니까 오류 발생
//    LombokClass(String title, String author, String publisher); => 모든 필드 값을 인자로 가지는 생성자를 이미 위에서 어노테이션으로 불렀는데, 여기서 재정의 하니까 오류 발생
}

public class G_Lombok {
    public static void main(String[] args) {

    }
}
