package com.nel.libalgorithm;

/**
 * Created by ningerlei on 18-5-16.
 */

public class InsertSort {

    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int x = a[i];
            int j;
            for (j = i; j > 0 && x < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = x;
        }
    }


    public static void shellSort(int[] a) {
        int dk = a.length / 2;
        while (dk >= 1) {
            shellInsertSort(a, dk);
            dk = dk / 2;
        }
    }

    private static void shellInsertSort(int[] a, int dk) {
        for (int i = dk; i < a.length; i++) {
            if (a[i] < a[i - dk]) {
                int x = a[i];
                int j;
                for (j = i; j >= dk && x < a[j - dk]; j = j - dk) {
                    a[j] = a[j - dk];
                }
                a[j] = x;

//                if (a[i] < a[i - dk]) {
//                    int tem = a[i];
//                    a[i] = a[i - dk];
//                    a[i - dk] = tem;
//                }
            }
        }
    }
}
