package org.example.chapter01;

import java.util.Scanner;

public class Z_Practice {
    public static void main(String[] args) {
        //복합 복습 문제

        Scanner sc = new Scanner(System.in);

        System.out.println("이름을 입력하시오 >> ");
        String name = sc.next();

        System.out.print("국어 점수를 입력하시오 >> ");
        int Lan = sc.nextInt();

        System.out.print("수학 점수를 입력하시오 >> ");
        int math = sc.nextInt();

        System.out.print("영어 점수를 입력하시오 >> ");
        int Eng = sc.nextInt();

        int total = Lan + math + Eng;
        float avg = (float) (total / 3.0);

        String isavgpass = avg >= 60 ? "합격" : "불합격";
        String ispass = (Lan >= 60 && math >= 60 && Eng >= 60) ? "합격" : "불합격";

        System.out.println("이름은 " + name);
        System.out.printf("총점은 %d 점입니다.", total);
        System.out.printf("평균은 %f 입니다", avg);
        System.out.println("평균은 " + isavgpass + "입니다.");
        System.out.println("각 과목별은 " + ispass + "입니다.");



    }
}
