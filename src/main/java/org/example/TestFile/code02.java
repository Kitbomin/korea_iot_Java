package org.example.TestFile;

import java.util.Scanner;

public class code02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int min = Integer.MAX_VALUE;

        int[] numList = new int[N];
        for (int i = 0; i < N; i++){
            numList[i] = sc.nextInt();
            if (numList[i] < min){
                min = numList[i];
            }
        }
        System.out.println(min);
        sc.close();
    }
}
