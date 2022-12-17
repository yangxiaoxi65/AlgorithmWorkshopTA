import java.util.*;

//Optimized Merge Sort algorithm
public class MergeSort{

    // Our algorithm class does not allow any instances
    private MergeSort(){}

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
            else if( aux[i-l].compareTo(aux[j-l]) < 0 ){ // The element pointed to by the left half <the element pointed by the right half
                arr[k] = aux[i-l]; i ++;
            }
            else{  // The element referred to in the left half >= the element referred to in the right half
                arr[k] = aux[j-l]; j ++;
            }
        }
    }

    // Recursively use merge sort to sort the range of arr[l...r]
    private static void sort(Comparable[] arr, int l, int r) {

        // Optimization 2: For small-scale arrays, use insertion sort
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = (l+r)/2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        // Optimization 1: For the case of arr[mid] <= arr[mid+1], do not merge
        // It is very effective for nearly ordered arrays, but for general cases, there is a certain performance loss
        if( arr[mid].compareTo(arr[mid+1]) > 0 )
            merge(arr, l, mid, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }


}
