package org.example.chapter02;

import java.util.Scanner;

public class E_Practice {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //1

        int score = sc.nextInt();

        if (score >= 0 || score <= 100){
            if (score >= 90) {
                System.out.println("A");

            } else if (score >= 80) {
                System.out.println("B");
            } else if (score >= 70) {
                System.out.println("C");
            } else if (score >= 60) {
                System.out.println("D");
            } else {
                System.out.println("F");
            }
        } else System.out.println("유효하지 않은 점수입니다.");


        //2-1
        char star = '*';
        char space = ' ';

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }System.out.println();
        }

        //2-2

        int rows = 5;//출력할 행의 수

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++){
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++){
                System.out.print("*");
            }System.out.println();
        }

    }
}
