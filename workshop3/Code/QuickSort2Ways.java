package unit6;

import java.util.*;

public class QuickSort2Ways {

    // Our algorithm class does not allow any instances to be generated
    private QuickSort2Ways(){}

    // Partition for two-way quick sort
    // return p, such that arr[l.. .p-1] < arr[p] ; arr[p+1... .r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r){

        // randomly in the range of arr[l... .r] range, choose a value as the calibration point pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l+1, j = r;
        while( true ){
            // Note the bound here, arr[i].compareTo(v) < 0, not arr[i].compareTo(v) <= 0

            while( i <= r && arr[i].compareTo(v) < 0 )
                i ++;

            // Note the bound here, arr[j].compareTo(v) > 0, not arr[j].compareTo(v) >= 0

            while( j >= l+1 && arr[j].compareTo(v) > 0 )
                j --;


            if( i > j )
                break;

            swap( arr, i, j );
            i ++;
            j --;
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

    // Test Quick Sort 2 Ways
    public static void main(String[] args) {

        // The two-way quick sort algorithm is also an O(nlogn) complexity algorithm
        // Can easily process 1 million orders of magnitude of data in less than 1 second
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("bobo.algo.QuickSort2Ways", arr);

        return;
    }
}
