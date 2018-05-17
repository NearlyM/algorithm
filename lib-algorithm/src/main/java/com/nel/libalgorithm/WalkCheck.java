package com.nel.libalgorithm;

/**
 *
 *
 * 有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 * 给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.
 * 测试样例：
 * [[1,2,3],[1,1,1]],2,3
 * 返回：4
 * Description :
 * CreateTime : 2018/5/8 10:00
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

public class WalkCheck {
    public static int method(int[][] map, int m, int n) {
        if (m < 0 || n < 0) {
            return -1;
        }
        int[][] temp = new int[m][n];
        int min = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[0][0] = map[i][j];
                } else if (i == 0) {
                    temp[i][j] = temp[i][j - 1] + map[i][j];
                } else if (j == 0) {
                    temp[i][j] = temp[i - 1][j] + map[i][j];
                } else {
                    temp[i][j] = Math.min(temp[i-1][j], temp[i][j - 1]) + map[i][j];
                }
                min = Math.min(temp[i][j], 1000);
            }
        }
        return min;
    }
}
