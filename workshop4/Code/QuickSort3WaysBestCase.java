package unit6;

import java.util.*;

public class QuickSort3WaysBestCase {

	    // Our algorithm class does not allow any instances to be generated
	    private QuickSort3WaysBestCase(){}

	    // recursive use of quick sort, sorting on the range of arr[l.. .r] in the range
	    private static void sort(Comparable[] arr, int l, int r){

	        // For small size arrays, use insertion sort
	        if( r - l <= 15 ){
	            InsertionSort.sort(arr, l, r);
	            return;
	        }

	        // In the ordered range of arr[l.... .r] range, choose the median as the calibration point pivot
	        Comparable v = arr[(l+r)/2];

	        int lt = l;     // arr[l+1...lt] < v
	        int gt = r + 1; // arr[gt...r] > v
	        int i = l+1;    // arr[lt+1...i) == v
	        while( i < gt ){
	            if( arr[i].compareTo(v) < 0 ){
	                swap( arr, i, lt+1);
	                i ++;
	                lt ++;
	            }
	            else if( arr[i].compareTo(v) > 0 ){
	                swap( arr, i, gt-1);
	                gt --;
	            }
	            else{ // arr[i] == v
	                i ++;
	            }
	        }

	        swap( arr, l, lt );

	        sort(arr, l, lt-1);
	        sort(arr, gt, r);
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
