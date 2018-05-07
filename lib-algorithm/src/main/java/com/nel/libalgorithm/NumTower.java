package com.nel.libalgorithm;

import java.util.Scanner;

/**
 * 例题1: 数塔取数问题
 *
 * 一个高度为N的由正整数组成的三角形，从上走到下，求经过的数字和的最大值。
 * 每次只能走到下一层相邻的数上，例如从第3层的6向下走，只能走到第4层的2或9上。
 *
 * 该三角形第n层有n个数字，例如：
 *
 * 第一层有一个数字：   5
 *
 * 第二层有两个数字：  8 4
 *
 * 第三层有三个数字： 3 6 9
 *
 * 第四层有四个数字：7 2 9 5
 *
 * 最优方案是：5 + 8 + 6 + 9 = 28
 *
 *注意:上面应该是排列成一个三角形的样子不是竖向对应的，排版问题没有显示成三角形。
 *
 * 状态定义: Fi，j是第i行j列项最大取数和，求第n行Fn，m（0 < m < n）中最大值。
 *
 * 状态转移方程：Fi，j = max{Fi-1,j-1,  Fi-1,j} + Ai,j
 *
 * Created by ningerlei on 18-5-7.
 */

public class NumTower {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[][] dp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <= i; j++) {
//                dp[i][j] = in.nextInt();
//            }
//        }
//
//        System.out.println(numTower(dp, n));


        Scanner in = new Scanner(System.in);
        String aStr = in.nextLine();
        String bStr = in.nextLine();
        int aLen = aStr.length();
        int bLen = bStr.length();
        int[][] dp = new int[aLen + 1][bLen + 1];
        for (int i = 0; i < aLen + 1; i++) dp[i][0] = i;
        for (int i = 0; i < bLen + 1; i++) dp[0][i] = i;
        for (int i = 1; i < aLen + 1; i++)
            for (int j = 1; j < bLen + 1; j++)
                if (aStr.charAt(i - 1) == bStr.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        System.out.println(dp[aLen][bLen]);
    }


    public static int numTower(int[][] arr, int m) {
        int max = 0;
        int[][] tem = new int[m][m];
        tem[0][0] = arr[0][0];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    tem[i][j] = tem[i-1][j] + arr[i][j];
                } else {
                    tem[i][j] = Math.max(tem[i - 1][j - 1], tem[i - 1][j]) + arr[i][j];
                }
                max = Math.max(tem[i][j], max);
            }
        }
        return max;
    }


















}
