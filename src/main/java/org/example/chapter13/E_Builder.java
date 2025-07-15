package org.example.chapter13;

/**
 * === 빌더 (Builder) 패턴 ===
 * : 소프트웨어 설계 객체 생성 방법 중 하나
 * - 객체 생성 방법
 * - 복잡한 객체를 단계별로 만들 때 사용
 * - 필드 (속성) 가 많거나, 필드에 필수값과 선택값이 섞여 있을 때 유용하게 사용 가능
 *
 * 1. 사용 목적
 *  : 생성자가 너무 많아질 때 (생성자 오버로딩)
 *  : 코드가 복잡하고 읽기 어려울 때 사용
 *
 * 2. 장단점
 * - 장점
 *    : 가독성 향상
 *    : 유연성 증가
 *    : 확장성 용이
 *
 * - 단점
 *    : 구현 복잡성 증가
 *    : 작은 객체에 사용하기엔 부적합함
 *
 * 3. 동작원리
 *  1) 객체 생성 시 필요한 데이터를 저장하는 Builder 클래스 생성
 *  2) Builder 클래스는 원하는 속성을 단계별로 설정 할 수 있는 하위 메서드 제공
 *  3) build() 메서드 호출하여 객체 생성
 *
 * 4. 사용 방법
 */

class Pizza {
    // 필수로 입력받아야 할 필수값 -> 사용자에게 필수로 받아옴
    private final String menu;
    private final String size;

    // 선택적으로 입력받을 선택값 -> 사용자가 수정하지 않는 이상 기본값이 들어감
    private final boolean cheese;
    private final boolean mushroom;
    private final boolean pepperoni;

//    // 초기값 생성자
//    public Pizza(String menu, String size) {
//        //필수값
//        this.menu = menu;
//        this.size = size;
//
//        //선택값
//        this.cheese = false;
//        this.mushroom = false;
//        this.pepperoni = false;
//    }
//
//    // 유저가 선택해서 값을 만드는 생성자
//    public Pizza(String menu, String size, boolean cheese, boolean mushroom, boolean pepperoni) {
//        //필수값
//        this.menu = menu;
//        this.size = size;
//
//        //선택값
//        this.cheese = cheese;
//        this.mushroom = mushroom;
//        this.pepperoni = pepperoni;
//    }

    // 1) Builder 클래스 정의(Pizza 클래스 내부의 클래스 -> 중첩클래스...?)
    public static class Builder {
        //static을 쓰는 이유 -> Pizza 클래스가 인스턴스화 되지 ㅇ낳을 대 내부 Builder 클래스로 인스턴스화를 진행함
        // 외부클래스명.내부클래스명(); => 으로 쓸 수 있음 => 그리고 얘 자체가 인스턴스임

        //필수 필드 지정
        private final String menu;
        private final String size;

        //선택 필드 (기본값) -> 추가하지 않으면 기본값으로 입력됨
        // final이 지정안되는 이유는 변동 가능성이 있는 값이기에
        private boolean cheeze = false;
        private boolean mushroom = false;
        private boolean pepperoni = false;

        // 필수 값 초기화
        public Builder(String menu, String size) {
            this.menu = menu;
            this.size = size;
        }

        //선택값 지정 메서드
        public Builder addCheese() {
            this.cheeze = true;
            return this; //this는 해당 클래스 타입의 객체 그 자체를 의미
        }

        public Builder addMushroom () {
            this.mushroom = true;
            return this;
        }

        public Builder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        // Builder 객체를 생성하는 build 메서드 생성
        public Pizza build() {
            return new Pizza(this);
        }
    }

    private Pizza(Builder builder) {
        this.menu = builder.menu;
        this.size = builder.size;

        // add~() 메서드 호출하지 않더라도 기본값이 false로 지정됨
        this.cheese = builder.cheeze;
        this.mushroom = builder.mushroom;
        this.pepperoni = builder.pepperoni;
    }

}

public class E_Builder {
    public static void main(String[] args) {
        //Pizza noBuilderPizza = new Pizza("파인애플 피자", "L", "false", "false", "false") => 원래 구조 설계라면 이렇게 해야함

        Pizza builderPizza = new Pizza.Builder("고구마 피자", "M").build();

        Pizza optionalPizza1 = new Pizza.Builder("포테이토 피자", "S") // Builder 인스턴스 생성
                                                .addCheese() //Builder 인스턴스 메서드 - 반환: Builder 객체
                                                .addMushroom()//Builder 인스턴스 메서드 - 반환: Builder 객체
                                                .build(); // Builder 인스턴스 메서드 - 반환: Pizza 객체

        Pizza optionalPizza2 = new Pizza.Builder("쉬림프 버거", "L").addPepperoni().build();

        // +) 메서드 체이닝
        //      : 메서드 호출 뒤 반환되는 데이터에 곧바로 추가 메서드를 호출
        //      - 객체를 연결고리로 메서드(함수)를 지속적으로 호출함

    }
}
