package unit6;

import java.util.*;

public class HeapSort {

    // Our algorithm class does not allow any instances to be generated
    private HeapSort(){}

    // Sort the entire arr array using MaxHeapSort
    // MaxHeapSort, add all the elements to the heap in order, and then take all the elements out of the heap in order, which completes the sort
    public static void sort(Comparable[] arr){

        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(n);
        for( int i = 0 ; i < n ; i ++ )
            maxHeap.insert(arr[i]);

        for( int i = n-1 ; i >= 0 ; i -- )
            arr[i] = maxHeap.extractMax();
    }
}