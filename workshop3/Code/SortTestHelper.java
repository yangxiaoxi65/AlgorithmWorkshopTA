package unit6;

import java.lang.reflect.Method;
import java.lang.Class;
import java.util.*;

public class SortTestHelper {

    // SortTestHelper does not allow any instances to be generated
    private SortTestHelper(){}

    // Generate a random array of n elements, each with a random range of [rangeL, rangeR].
    public static Integer[] generateRandomArray(int n, int rangeL, long rangeR) {

        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++)
            arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
        return arr;
    }


    public static Integer[] generateOrderedArrayFromSToL(int n){
//    	System.out.println("n is " + n);
//    	System.out.println("********************");
        Integer[] arr = new Integer[n];
        
        for(int i = 0; i < n ; i ++ ) {
            arr[i] = new Integer(i);
//            System.out.println("i is " + i);
        }
//        System.out.println("n is " + n);
        return arr;
    }
    public static Integer[] generateOrderedArrayFromLToS(int n){

        Integer[] arr = new Integer[n];
        for( int i = n-1 ; i >= 0 ; i -- )
            arr[n-1-i] = new Integer(i);
        return arr;
    }
    // Print all the contents of the arr array
    public static void printArray(Object[] arr) {

        for (int i = 0; i < arr.length; i++){
            System.out.print( arr[i] );
            System.out.print( ' ' );
        }
        System.out.println();

        return;
    }

    // Determine if the arr array is ordered
    public static boolean isSorted(Comparable[] arr){

        for( int i = 0 ; i < arr.length - 1 ; i ++ )
            if( arr[i].compareTo(arr[i+1]) > 0 )
                return false;
        return true;
    }

    // Test the correctness of the results obtained by sorting the arr array by the sorting algorithm corresponding to sortClassName and the running time of the algorithm
    // Print the running time of the algorithm on the console
    public static long testSort(String sortClassName, Comparable[] arr){

        // Run the sort function through Java's reflection mechanism by sorting the class name
        try{
            // Get the Class object of the sorting function by sortClassName
            Class sortClass = Class.forName(sortClassName);
            // Get the sorting method through the Class object of the sorting function
            Method sortMethod = sortClass.getMethod("sort",new Class[]{Comparable[].class});
            // There is only one sort parameter, which is a comparable array arr
            Object[] params = new Object[]{arr};

            long startTime = System.nanoTime();
            // Calling the sort function
            sortMethod.invoke(null,params);
            long endTime = System.nanoTime();

            assert isSorted( arr );

//            System.out.println( sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ns" );
            return (endTime-startTime);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    // Test the correctness of the results obtained by sorting the arr array by the sorting algorithm corresponding to sortClassName and the running time of the algorithm
    // Returns the running time of the algorithm as a long type, in milliseconds (ms)
    public static long testSort2(String sortClassName, Comparable[] arr){

        // Run the sort function through Java's reflection mechanism by sorting the class name
        try{
            // Get the Class object of the sorting function by sortClassName
            Class sortClass = Class.forName(sortClassName);
            // Get the sorting method through the Class object of the sorting function
            Method sortMethod = sortClass.getMethod("sort",new Class[]{Comparable[].class});
            // There is only one sort parameter, which is a comparable array arr
            Object[] params = new Object[]{arr};

            long startTime = System.nanoTime();
            // Calling the sort function
            sortMethod.invoke(null,params);
            long endTime = System.nanoTime();

            assert isSorted( arr );

            return endTime - startTime;
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return 0;
    }
}