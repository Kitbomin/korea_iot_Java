package org.example.chapter16;

/**
 * === Enum 메서드 오버라이딩 ===
 * : ENUM은 상수별 다른 동작을 정의할 수 있음
 *   - abstract 메서드를 선언하고 상수별 구현이 가능함
 */

enum Operation {
    // enum은 상수값 정의가 먼저여야함
    ADD {
        @Override
        public int apply(int x, int y) {
            return x+y;
        }
    },

    SUBTRACT {
        @Override
        public int apply(int x, int y) {
            return x-y;
        }
    },

    MULTIPLY {
        @Override
        public int apply(int x, int y) {
            return x * y;
        }
    },

    DIVISION {
        @Override
        public int apply(int x, int y) {
            return x / y;
        }
    };
    public abstract int apply(int x, int y);
}


enum Season {
    SPRING("봄"), SUMMER("여름"), AUTUMN("가을"), WINTER("겨울");

    private final String seasonName;

    Season(String seasonName) {
        this.seasonName = seasonName;
    }//시즌의 네임이 봄여름가을겨울이 아니면 입력 못하게 방지하고 있음

    public String getSeasonName() {
        return seasonName;
    }
}


public class C_Enum {
    public static void main(String[] args) {
        System.out.println(Operation.ADD.apply(3,5));
        System.out.println(Operation.SUBTRACT.apply(3,5));
        System.out.println(Operation.MULTIPLY.apply(3,5));
        System.out.println(Operation.DIVISION.apply(7,3));


        Season season = Season.AUTUMN;


        switch (season) {
            case SPRING ->
                System.out.println("봄봄봄");


            case SUMMER ->
                System.out.println("여름여름여름");

            case AUTUMN ->
                System.out.println("가을가을가을");


            case WINTER ->
                System.out.println("겨울겨울경ㄹ");

        }


    }
}
