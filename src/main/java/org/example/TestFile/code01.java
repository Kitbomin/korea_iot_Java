package org.example.TestFile;


import java.util.Scanner;

public class code01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        String result = (B == 0) ? "0으로 나눌 수 없습니다.": String.valueOf(A/B);

        System.out.println(result);

        sc.close();
    }
}
