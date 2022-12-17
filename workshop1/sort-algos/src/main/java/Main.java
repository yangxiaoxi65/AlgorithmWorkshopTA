
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static int nbRep = 10; // Repeating each execution nbRep times to avoid biased execution situations
	public static int iMin = 100; 
	public static int iMax = 5000;
	public static int iStep = 100;
	public static String caseRuning = "A";// B:Best, W:Worst, A:Average
	public static long start, end, tInsertion, tSelection, tMerge, tTheoryN, tTheoryNSquare,tTheoryNLog2n;
	public static int k = 2;

	public static void main(String[] args) throws IOException {
		//test();
		assess();

	}

	public static void initTime() {
		tInsertion = 0;
		tSelection = 0;
		tMerge = 0;
		tTheoryN = 0;
		tTheoryNSquare = 0;
		tTheoryNLog2n = 0;
	}

	public static void assess() throws IOException {

		String resFileName = "";
		if (caseRuning == "A") {
			resFileName = "sort-results-average.txt";
		} else if (caseRuning == "B") {
			resFileName = "sort-results-best.txt";
		} else {
			resFileName = "sort-results-worst.txt";
		}
		FileWriter myWriter = new FileWriter(resFileName);

		for (int i = iMin; i <= iMax; i += iStep) {// Analysis of the size of the array

			initTime();

			for (int j = 0; j <= nbRep; j++) {// Repeating execution in order to avoid biased execution cases
				int randArray[] = Utils.generateRandom(i, k);

				if (caseRuning == "B") {
					randArray = Arrays.stream(randArray).boxed().sorted().mapToInt(Integer::intValue).toArray();
				} else if (caseRuning == "W") {
					randArray = Arrays.stream(randArray).boxed().sorted(Collections.reverseOrder())
							.mapToInt(Integer::intValue).toArray();
				}

				int arrInsertion[] = Utils.copyArray(randArray);
				int arrSelection[] = Utils.copyArray(randArray);
				int arrMerge[] = Utils.copyArray(randArray);

				// Selection Sort
				start = System.nanoTime();
				SelectionSort.sort(arrSelection);
				end = System.nanoTime();
				tSelection += (end - start);

				// Insertion sort
				start = System.nanoTime();
				InsertionSort.sort(arrInsertion);
				end = System.nanoTime();
				tInsertion += (end - start);

				// Merge sort
				start = System.nanoTime();
				MergeSort.sort(arrMerge, 0, i - 1);
				end = System.nanoTime();
				tMerge += (end - start);

				// Theory N
				start = System.nanoTime();
				waitN(i);
				end = System.nanoTime();
				tTheoryN += (end - start);

				// Theory N Square
				start = System.nanoTime();
				waitNSquare(i);
				end = System.nanoTime();
				tTheoryNSquare += (end - start);

				// Theory N LogN
				start = System.nanoTime();
				waitNLog2N(i);
				end = System.nanoTime();
				tTheoryNLog2n += (end - start);

			}
			System.out.println("Array Size: " + i + " SelectionSort Time:" + (tSelection / nbRep)
					+ " InsertionSort Time:" + (tInsertion / nbRep) + " MergeSort Time:" + (tMerge / nbRep));
			// Append Result to a result File
			myWriter.append(i + "," + (tSelection / nbRep) + "," + (tInsertion / nbRep) + "," + (tMerge / nbRep) + ","
					 + (tTheoryN / nbRep) + "," + (tTheoryNSquare / nbRep) + "," + (tTheoryNLog2n / nbRep) + "\n");
		}
		myWriter.close();
	}

	public static void waitN(long n) {
		for (int i = 0; i < n; i++) {
		}
	}

	public static void waitNSquare(long n) {
		for (int i = 0; i < n * n; i++) {
		}
	}

	public static void waitNLog2N(long n) {
		long nLog2n = n * Utils.log2(n);
		for (int i = 0; i < nLog2n; i++) {
		}
	}

	public static void test() {
		int randArray[] = Utils.generateRandom(10, 100);

		int arrInsertion[] = Utils.copyArray(randArray);
		int arrSelection[] = Utils.copyArray(randArray);
		int arrMerge[] = Utils.copyArray(randArray);

		// Test Selection Sort
		System.out.println(" Selection Sort: ");
		SelectionSort.sort(arrSelection);
		SelectionSort.printArray(arrSelection);

		// Test insertion sort
		System.out.println(" Insertion Sort: ");
		InsertionSort.sort(arrInsertion);
		InsertionSort.printArray(arrInsertion);

		// Test Merge sort
		System.out.println(" Merge Sort: ");
		InsertionSort.sort(arrMerge);
		InsertionSort.printArray(arrInsertion);
	}
}
