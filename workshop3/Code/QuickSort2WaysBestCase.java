package unit6;

import java.util.*;

public class QuickSort2WaysBestCase {

    // Our algorithm class does not allow any instances to be generated
    private QuickSort2WaysBestCase(){}

    // Partition for two-way fast sort
    // return p, such that arr[l.. .p-1] < arr[p] ; arr[p+1... .r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r){

        // In the ordered range of arr[l.... .r] range, choose the median as the calibration point pivot
        Comparable v = arr[(l+r)/2];

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

}
