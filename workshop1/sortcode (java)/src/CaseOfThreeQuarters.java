import java.util.Arrays;


public class CaseOfThreeQuarters {


    public static void main(String[] args) {
        for (int N = 100; N <= 10000; N += 100) {
            CaseOfAHalf(N);
        }

    }
    public static void CaseOfAHalf(int N){
        int n =  N*3/4;
        Integer[] arr1 = new Integer[N];
        for( int i = 0 ; i < n ; i ++ )
            arr1[i] = new Integer(i);
        Integer[] arr2 = SortTestHelper.generateRandomArray(N-n, 0, N);
        for( int i = n ; i < N ; i ++ )
            arr1[i] = arr2[i-n];

        System.out.println("Test for 75% random array, size = " + N + " , random range [0, " + N + "]");
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("AS1.SelectionSort", arr1);
        SortTestHelper.testSort("AS1.InsertionSort", arr3);
        SortTestHelper.testSort("AS1.MergeSort", arr4);
        System.out.println();

    }



}
