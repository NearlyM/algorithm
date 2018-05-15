package com.nel.libalgorithm;

/**
 * https://blog.csdn.net/happy_wu/article/details/51841244
 *
 * Created by ningerlei on 18-5-15.
 */

public class QuickSort {

    public static void main(String[] argv) {
        int[] a = {3,1,5,7,2,4,9,6,10,8, 3, 4, 5, 34, 767, 2 , 43};
        shellSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + ": " + a[i]);
        }
    }

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

    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int k = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[k] > a[j]) {
                    k = j;
                }
            }

            int temp = a[i];
            a[i] = a[k];
            a[k] = temp;
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
