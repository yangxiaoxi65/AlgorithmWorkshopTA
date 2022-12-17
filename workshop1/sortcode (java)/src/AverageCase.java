package AS1;
import java.util.ArrayList;
import java.util.Arrays;

public class AverageCase {
    public static void main(String[] args) {
        for (int N = 100; N <= 10000; N += 100) {
            AverageCase(N);
        }

    }
    public static void AverageCase(int N){

        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("SelectionSort", arr1);
        SortTestHelper.testSort("InsertionSort", arr2);
        SortTestHelper.testSort("MergeSort", arr3);
        System.out.println();

    }

}
