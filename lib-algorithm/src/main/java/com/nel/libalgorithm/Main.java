package com.nel.libalgorithm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[][] dp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <= i; j++) {
//                dp[i][j] = in.nextInt();
//            }
//        }
//
//        System.out.println(numTower(dp, n));


//        Scanner in = new Scanner(System.in);
//        String aStr = in.nextLine();
//        String bStr = in.nextLine();
//        int aLen = aStr.length();
//        int bLen = bStr.length();
//        int[][] dp = new int[aLen + 1][bLen + 1];
//        for (int i = 0; i < aLen + 1; i++) dp[i][0] = i;
//        for (int i = 0; i < bLen + 1; i++) dp[0][i] = i;
//        for (int i = 1; i < aLen + 1; i++)
//            for (int j = 1; j < bLen + 1; j++)
//                if (aStr.charAt(i - 1) == bStr.charAt(j - 1))
//                    dp[i][j] = dp[i - 1][j - 1];
//                else
//                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
//        System.out.println(dp[aLen][bLen]);

//        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
//        int n = scanner.nextInt();
//
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                dp[i][j] = scanner.nextInt();
//            }
//        }
//
//        int method = WalkCheck.method(dp, m, n);
//        System.out.println(method);

//        int n = in.nextInt();
//        System.out.println(StepQuestion.method(n));

        String a = "1A2C3D4B56"; //,10,
        String b = "B1D23CA45B6A"; //,12
        System.out.println(LCSQuestion.method(a, b));
    }
}
