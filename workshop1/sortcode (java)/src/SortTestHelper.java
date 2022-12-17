package AS1;
import java.lang.reflect.Method;
import java.lang.Class;
import java.security.InvalidAlgorithmParameterException;
import java.util.Random;

public class SortTestHelper {

    // SortTestHelper does not allow any instances
    private SortTestHelper(){}

    // Generate a random array with n elements, the random range of each element is [rangeL, rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++)
            arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
        return arr;
    }

    // Generate an almost ordered array
    // First generate a completely ordered array containing [0...n-1], then randomly exchange swapTimes pairs of data
    // swapTimes defines the degree of disorder of the array:
    // When swapTimes == 0, the array is completely ordered
    // The larger the swapTimes, the more disorder the array tends to be
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes){

        Integer[] arr = new Integer[n];
        for( int i = 0 ; i < n ; i ++ )
            arr[i] = new Integer(i);

        for( int i = 0 ; i < swapTimes ; i ++ ){
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

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

    // Determine whether the arr array is in order
    public static boolean isSorted(Comparable[] arr){

        for( int i = 0 ; i < arr.length - 1 ; i ++ )
            if( arr[i].compareTo(arr[i+1]) > 0 )
                return false;
        return true;
    }

    // Test the correctness of the results obtained by sorting the arr array by the sorting algorithm corresponding to sortClassName and the running time of the algorithm
    public static void testSort(String sortClassName, Comparable[] arr){

        // Through the Java reflection mechanism, through the sorted class name, run the sorting function
        try{
            // Obtain the Class object of the sort function through sortClassName
            Class sortClass = Class.forName(sortClassName);
            // Get the sorting method through the Class object of the sorting function
            Method sortMethod = sortClass.getMethod("sort",new Class[]{Comparable[].class});
            // There is only one sort parameter, which is a comparable array arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // Call the sort function
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            assert isSorted( arr );
            if(!isSorted(arr))
                throw new InvalidAlgorithmParameterException("sort failed!");

            System.out.println(sortClass.getSimpleName()+ " : " +(endTime-startTime)*1000000+"ns");
//            System.out.println((endTime-startTime)*1000000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}