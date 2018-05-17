package com.nel.libalgorithm;

/**
 * Created by ningerlei on 18-5-16.
 */

public class SelectSort {


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
}
