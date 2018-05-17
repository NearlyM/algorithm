package com.nel.libalgorithm;

/**
 * Description :
 * CreateTime : 2018/5/8 11:47
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

public class LCSQuestion {
    public static int method(String a, String b) {
        if (isEmpty(a) || isEmpty(b)) {
            return 0;
        }

        int aLength = a.length();
        int bLength = b.length();
        int[][] temp = new int[aLength][bLength];
        for (int i = 0; i < aLength; i++) {
            for (int j = 0; j < bLength; j++) {
                if (i == 0 || j == 0) {
                    if (a.charAt(i) == b.charAt(j)) {
                        temp[i][j] = 1;
                    } else {
                        if (i == 0 && j == 0) {
                            temp[i][j] = 0;
                        } else if (i == 0) {
                            temp[i][j] = temp[i][j - 1];
                        } else {
                            temp[i][j] = temp[i - 1][j];
                        }
                    }
                } else {
                    if (a.charAt(i) == b.charAt(j)) {
                        temp[i][j] = Math.max(temp[i - 1][j - 1] + 1, Math.max(temp[i][j - 1], temp[i - 1][j]));
                    } else {
                        temp[i][j] = Math.max(temp[i - 1][j], temp[i][j - 1]);
                    }
                }
            }
        }

        return temp[aLength - 1][bLength - 1];
    }

    private static boolean isEmpty(String s) {
        return s == null || "".equals(s);
    }
}
