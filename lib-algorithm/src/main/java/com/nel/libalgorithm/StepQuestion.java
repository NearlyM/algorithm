package com.nel.libalgorithm;

/**
 *
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 * 测试样例：
 * 1
 * 返回：1
 * 解析：这是一个非常经典的为题，设f(n)为上n级台阶的方法，要上到n级台阶的最后一步有两种方式：从n-1级台阶走一步；从n-1级台阶走两步，于是就有了这个公式f(n) = f(n-1)+f(n-2);
 * Description :
 * CreateTime : 2018/5/8 11:25
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

public class StepQuestion {
    public static int method(int n) {
        if (n <= 2) {
            return n;
        }
        int[] temp = new int[n + 1];
        temp[0] = 0;
        temp[1] = 1;
        temp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            temp[i] = (temp[i - 1] + temp[i - 2]) % 1000000007;
        }

        return temp[n];
    }
}
