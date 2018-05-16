package com.nel.libalgorithm;

/**
 * Created by ningerlei on 18-5-16.
 */

public class ChangeSort {

    public static void bubbleSort(int[] a, int n) {
        if (a == null || n > a.length) {
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    int tem = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tem;
                }
            }
        }
    }

    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int partition = partition(a, low, high);
            quickSort(a, low, partition - 1);
            quickSort(a, partition + 1, high);
        }
    }

    public static int partition(int[] a, int low, int high) {
        int guard = a[low];
        while (low < high) {
            while (low < high && guard <= a[high]) {
                high--;
            }
            a[low] = a[high];

            while (low < high && guard >= a[low]) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = guard;
        return low;
    }
}
