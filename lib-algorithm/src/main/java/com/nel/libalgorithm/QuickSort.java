package com.nel.libalgorithm;

/**
 * https://blog.csdn.net/happy_wu/article/details/51841244
 *
 * Created by ningerlei on 18-5-15.
 */

public class QuickSort {

    public static void main(String[] argv) {
        int[] a = {3,1,5,7,2,4,9,6,10,8, 3, 4, 5, 34, 767, 2 , 43};
//        InsertSort.shellSort(a);
//        ChangeSort.bubbleSort(a, a.length);
        ChangeSort.quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + ": " + a[i]);
        }
    }


}
