
import java.util.ArrayList;
import java.util.Random;

public class Utils {

    public static int[] generateRandom(int size, int max) {
	int randArr[] = new int[size];
	for (int i = 0; i < size; i++) {
	    Random r = new Random();
	    randArr[i] = r.nextInt((max - 0) + 1);
	}
	return randArr;
    }

    public static int[] copyArray(int arr[]) {
	int copiedRrray[] = new int[arr.length];
	for (int i = 0; i < arr.length; i++)
	    copiedRrray[i] = arr[i];
	return copiedRrray;
    }

    public static int[] convertIntegers(ArrayList<Integer> integers) {
	int[] ret = new int[integers.size()];
	for (int i = 0; i < ret.length; i++) {
	    ret[i] = integers.get(i).intValue();
	}
	return ret;
    }

    // Function to calculate the
    // log base 2 of an integer
    public static long log2(long N) {
	long result = (long) (Math.log(N) / Math.log(2));
	return result;
    }
}
