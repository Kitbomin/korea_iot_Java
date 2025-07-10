package org.example.MyPractice;

import java.util.Scanner;

class Operation {

    //더하기 오버로딩
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {return a + b;}
    double add (int a, double b){return a+b;}
    double add (double a, int b){return a+b;}
    int add (short a, short b){return a+b;}
    double add (double a, double b, double c) {return a+b+c;}

    int subtract(int a, int b) {
        return a - b;
    }
    double subtract(double a, double b) {return a - b;}
    double subtract (int a, double b){return a-b;}
    double subtract (double a, int b){return a-b;}
    int subtract (short a, short b){return a-b;}
    double subtract (double a, double b, double c) {return a-b-c;}

    int multiply(int a, int b) {
        return a * b;
    }
    double multiply(double a, double b) {return a * b;}
    double multiply (int a, double b){return a*b;}
    double multiply (double a, int b){return a*b;}
    int multiply (short a, short b){return a*b;}
    double multiply (double a, double b, double c) {return a*b*c;}

    double divide(double a, double b) {
        if (b == 0) {
            System.out.println("정수 0으로 나눌 수 없습니다.");
            return b;
        } else {
            return a / b;
        }

    }

    double doubleDivided(int a, double b) {
        return a / b;
    }

    void noReturn() {
        System.out.println("해당 메소드는 반환값이 없습니다.");
    }

    public static class calculating_al {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            Operation op = new Operation();


            System.out.println(op.add(sc.nextInt(),sc.nextInt()));
            System.out.println(op.add(sc.nextDouble(),sc.nextDouble()));
            System.out.println(op.subtract(sc.nextInt(),sc.nextInt()));
            System.out.println(op.subtract(sc.nextDouble(),sc.nextDouble()));
            System.out.println(op.multiply(sc.nextInt(),sc.nextInt()));
            System.out.println(op.multiply(sc.nextDouble(),sc.nextDouble()));
            System.out.println(op.divide(sc.nextDouble(),sc.nextDouble()));

        }
    }
}
