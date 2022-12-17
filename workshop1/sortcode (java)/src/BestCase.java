package 3440.workshop.AS1;
import java.util.Arrays;

public class BestCase {

    public static void main(String[] args) {
        for (int N = 100; N <= 10000; N += 100) {
            BestCase(N);
        }
    }
    public static void BestCase(int N){
        Integer[] arr1 = new Integer[N];
        for( int i = 0 ; i < N ; i ++ )
            arr1[i] = new Integer(i);
        System.out.println("Test for best case, size = " + N );

        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        3440.workshop.AS1.SortTestHelper.testSort("AS1.SelectionSort", arr1);
        SortTestHelper.testSort("AS1.InsertionSort", arr2);
        SortTestHelper.testSort("AS1.MergeSort", arr3);
    }
}
