package AS1;
import java.util.*;

public class SelectionSort{

    //  Our algorithm class does not allow any instances
    private SelectionSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;
        for( int i = 0 ; i < n ; i ++ ){
            // Find the index of the smallest value in the interval (i, n)
            int minIndex = i;
            for( int j = i + 1 ; j < n ; j ++ )
                // Use compareTo method to compare the size of two Comparable objects
                if( arr[j].compareTo( arr[minIndex] ) < 0 )
                    minIndex = j;

            swap( arr , i , minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


}