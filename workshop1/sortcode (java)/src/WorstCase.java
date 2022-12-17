import java.util.Arrays;

public class WorstCase {
    public static void main(String[] args) {
        for (int N = 100; N <= 10000; N += 100) {
            WorstCase(N);
        }

    }
    public static void WorstCase(int N){
        Integer[] arr1 = new Integer[N];
        for( int i = N ; i > 0 ; i -- )
            arr1[N-i] = new Integer(i);
        System.out.println("Test for worst case, size = " + N );
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("AS1.SelectionSort", arr1);
        SortTestHelper.testSort("AS1.InsertionSort", arr2);
        SortTestHelper.testSort("AS1.MergeSort", arr3);
        SortTestHelper.testSort("AS1.MergeSortBU", arr4);
        System.out.println();


    }
}

