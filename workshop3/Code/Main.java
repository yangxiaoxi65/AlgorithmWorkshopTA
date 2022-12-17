package unit6;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int N = 10000;
        for(int n = 100; n <= N; n+= 100) {
//        	System.err.println("n is " + n);
        	long quickSortTime = 0;
        	long heapSortTimeWorst = 0;
        	long heapSortTimeWorst1 = 0;
        	long heapSortTimeBest = 0;
        	long heapSortTimeAvg = 0;
        	long radixSortTime = 0;
        	long quickSortTime2Ways = 0;
        	long quickSortTime3Ways = 0;
        	for (int i = 0; i <= 100; i++) {
		        // 1. Average case for all sort
//	        	System.out.println("Test for random array, size = " + n + " , random range [0, " + n + "]");
//        		Integer[] arr1 = SortTestHelper.generateRandomArray(n, 0, n);
//        		heapSortTimeAvg += SortTestHelper.testSort("unit6.HeapSort", arr1);
//		        quickSortTime += SortTestHelper.testSort("unit6.QuickSort", arr1);
//		        radixSortTime += SortTestHelper.testSort("unit6.RadixSort", arr1);
//		        quickSortTime2Ways += SortTestHelper.testSort("unit6.QuickSort2Ways", arr1);
//		        quickSortTime3Ways += SortTestHelper.testSort("unit6.QuickSort3Ways", arr1);

//        		// 2. Best case for heap sort 
//        		System.out.println("Best arr: ");
//        		System.out.println("Best: " + (heapSortTimeBest));
//        		Integer[] arr1 = SortTestHelper.generateRandomArray(n, 0, 0);
//        		System.out.println(Arrays.toString(arr1));
//        		heapSortTimeBest += SortTestHelper.testSort("unit6.HeapSort", arr1);
//        		System.out.println(Arrays.toString(arr1));
//        		System.out.println("Best: " + (heapSortTimeBest));
		        // 3. Best case for quick sort 
		        Integer[] arr1 = SortTestHelper.generateOrderedArrayFromSToL(n);
		        quickSortTime += SortTestHelper.testSort("unit6.QuickSortBestCase", arr1);
//		        quickSortTime2Ways += SortTestHelper.testSort("unit6.QuickSort2WaysBestCase", arr1);
//		        quickSortTime3Ways += SortTestHelper.testSort("unit6.QuickSort3WaysBestCase", arr1);
		       
		        // 4. Best case for radix sort
//		        Integer[] arr1 = SortTestHelper.generateRandomArray(n, 0, 10);
//		        radixSortTime += SortTestHelper.testSort("unit6.RadixSort", arr1);
        		
//	 	        // 5. worst case for heap sort 
//		        System.out.println("Worst arr: ");
//		        System.out.println("Worst: " + (heapSortTimeWorst));
//	 	        Integer[] arr2 = SortTestHelper.generateOrderedArrayFromLToS(n);
//	 	        System.out.println(Arrays.toString(arr2));
//	 	        heapSortTimeWorst += SortTestHelper.testSort("unit6.HeapSort", arr2);
//	 	        System.out.println(Arrays.toString(arr2));
//	 	        System.out.println("Worst: " + (heapSortTimeWorst));
	 	        
//		        System.out.println("Worst arr: ");
//		        System.out.println("Worst: " + (heapSortTimeWorst1));
//	 	        Integer[] arr4 = SortTestHelper.generateOrderedArrayFromSToL(n);
//	 	        System.out.println(Arrays.toString(arr4));
//	 	        heapSortTimeWorst1 += SortTestHelper.testSort("unit6.HeapSort", arr4);
//	 	        System.out.println(Arrays.toString(arr4));
//	 	        System.out.println("Worst: " + (heapSortTimeWorst1));
	 	        
        		// 6. worst case for quick sort
//	 	        In this case, the ordinary QuickSort degenerates to an O(n^2) algorithm
//        		Integer[] arr2 = SortTestHelper.generateRandomArray(n, 0, 0);
// 		        quickSortTime += SortTestHelper.testSort("unit6.QuickSort", arr2);
//	 	        SortTestHelper.testSort("unit6.QuickSort3Ways", arr2);

//	        	SortTestHelper.testSort("unit6.HeapSort", arr2);
//	 	        System.out.println("Average arr: ");
//	 	        System.out.println("Average: " + (heapSortTimeAvg));
//	 	        System.out.println(Arrays.toString(arr3));
//	 	        System.out.println(Arrays.toString(arr3));
//	 	        System.out.println("Average: " + (heapSortTimeAvg));

        		// 7. worst case for radix sort 
//		        Integer[] arr1 = SortTestHelper.generateRandomArray(n, 0, 1000000000);
//		        radixSortTime += SortTestHelper.testSort("unit6.RadixSort", arr1);
        		
        	}
        	System.out.println((quickSortTime /= 100));
//        	System.out.println(heapSortTimeAvg/=100);
//        	System.out.println(heapSortTimeWorst1/=100);
//        	System.out.println(radixSortTime /=100);
//        	System.out.println(quickSortTime2Ways /=100);
//        	System.out.println(quickSortTime3Ways /=100);
	    }
        
    }
}
