package org.example.test.자바OOP구현문제;

interface Playable {
    default String play(String q) {
        return q;
    }
}

class Piano implements Playable {
    String pianosound;
    @Override
    public String play(String pianosound) {
        System.out.println(pianosound);
        return pianosound;
    }
}

class Guitar implements Playable {
    String guitarsound;
    @Override
    public String play(String guitarsound) {
        System.out.println(guitarsound);
        return guitarsound;
    }
}


public class Q4 {
    public static void main(String[] args) {
        Piano piano = new Piano();
        Guitar guitar = new Guitar();

        if (piano instanceof Playable) {
            System.out.println(piano.play("또로롤ㅇ"));
        } else {
            System.out.println("소리가 나질 않아요...");
        }

        if(guitar instanceof Playable) {
            System.out.println(guitar.play("지가징"));
        }


    }
}
