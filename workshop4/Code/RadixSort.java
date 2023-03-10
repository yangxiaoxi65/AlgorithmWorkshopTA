package unit6;

import java.util.*;

//Radix sort Java implementation

public class RadixSort {

	// A utility function to get maximum value in arr[]
	public static Comparable getMax(Comparable[] arr, int n) {
		 Comparable mx = arr[0];
		 for (int i = 1; i < n; i++)
		     if (arr[i].compareTo(mx) > 0)
		         mx = arr[i];
		 return mx;
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	public static void countSort(Comparable[] arr, int n, int exp) {
	     int output[] = new int[n]; // output array
	     int i;
	     int count[] = new int[10];
	     Arrays.fill(count, 0);
	
	     // Store count of occurrences in count[]
	     for (i = 0; i < n; i++)
	         count[((int)arr[i] / exp) % 10]++;
	
	     // Change count[i] so that count[i] now contains
	     // actual position of this digit in output[]
	     for (i = 1; i < 10; i++)
	         count[i] += count[i - 1];
	
	     // Build the output array
	     for (i = n - 1; i >= 0; i--) {
	         output[count[((int)arr[i] / exp) % 10] - 1] = (int)arr[i];
	         count[((int)arr[i] / exp) % 10]--;
	     }
	
	     // Copy the output array to arr[], so that arr[] now
	     // contains sorted numbers according to current digit
	     for (i = 0; i < n; i++)
	         arr[i] = output[i];
 }

	// The main function to that sorts arr[] of size n using
	// Radix Sort
	public static void sort(Comparable[] arr) {
	     // Find the maximum number to know number of digits
		int n = arr.length;
		int m = (int)getMax(arr, n);
	
	     // Do counting sort for every digit. Note that
	     // instead of passing digit number, exp is passed.
	     // exp is 10^i where i is current digit number
	     for (int exp = 1; m / exp > 0; exp *= 10)
	         countSort(arr, n, exp);
 }

//	// A utility function to print an array
//	public static void print(int arr[], int n) {
//	     for (int i = 0; i < n; i++) {
//	         System.out.print(arr[i] + " ");
//	     }
// }

//	/*Driver Code*/
//	public static void main(String[] args) {
//	     int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
//	     int n = arr.length;
//	        
//	       // Function Call
//	     radixsort(arr, n);
//	     print(arr, n);
// }
}