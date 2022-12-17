package unit6;

import java.util.*;

public class QuickSort {

    // Our algorithm class does not allow any instances to be generated
    private QuickSort(){}

    // Partition the arr[l.. .r] partition operation
    // return p, such that arr[l.. .p-1] < arr[p] ; arr[p+1... .r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r){

        // randomly in the range of arr[l... .r] range, choose a value as the calibration point pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v = arr[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for( int i = l + 1 ; i <= r ; i ++ )
            if( arr[i].compareTo(v) < 0 ){
                j ++;
                swap(arr, j, i);
            }

        swap(arr, l, j);

        return j;
    }

    // recursive use of quick sort, sorting on the range of arr[l.. .r] in the range
    private static void sort(Comparable[] arr, int l, int r){

        // For small size arrays, use insertion sort
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p-1 );
        sort(arr, p+1, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
