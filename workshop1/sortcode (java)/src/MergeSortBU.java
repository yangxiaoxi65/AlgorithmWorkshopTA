import java.util.*;

//Merge Sort BU is also an O(nlogn) complexity algorithm, although only two for loops are used
//So, Merge Sort BU can also easily process 1 million orders of data within 1 second
public class MergeSortBU{

    // Our algorithm class does not allow any instances
    private MergeSortBU(){}

    // Combine the two parts of arr[l...mid] and arr[mid+1...r]
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        // Initialization, i points to the left half of the starting index position l; j points to the right half of the starting index position mid+1
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid ){  // If the left half of the elements have all been processed
                arr[k] = aux[j-l]; j ++;
            }
            else if( j > r ){   // If the right half of the elements have all been processed
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l].compareTo(aux[j-l]) < 0 ){  // The element pointed to by the left half <the element pointed by the right half
                arr[k] = aux[i-l]; i ++;
            }
            else{  // The element referred to in the left half >= the element referred to in the right half
                arr[k] = aux[j-l]; j ++;
            }
        }
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;

        // Merge Sort Bottom Up Unoptimized version:
//        for (int sz = 1; sz < n; sz *= 2)
//            for (int i = 0; i < n - sz; i += sz+sz)
//                // Merge arr[i...i+sz-1] and arr[i+sz...i+2*sz-1]
//                merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1));

        // Merge Sort Bottom Up optimization
        // For small arrays, use insertion sort optimization
        for( int i = 0 ; i < n ; i += 16 )
            InsertionSort.sort(arr, i, Math.min(i+15, n-1) );

        for( int sz = 16; sz < n ; sz += sz )
            for( int i = 0 ; i < n - sz ; i += sz+sz )
                // For arr[mid] <= arr[mid+1], do not merge
                if( arr[i+sz-1].compareTo(arr[i+sz]) > 0 )
                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );

    }

}
