import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    
    public static void main(String[] args) {

        int[] arrSizeFiftyThousand = new int[50000]; 
        int[] arraySizeHundredThousand = new int[100000];
        int[] arraySizeTwoHundredThousand = new int[200000];
        
        List<int[]> list = Arrays.asList(
            arrSizeFiftyThousand,
            arraySizeHundredThousand,
            arraySizeTwoHundredThousand
        );

        executeAlgorithm(list);
        
    }

    /**
     * Randomizes a given array
     * @param array
     */
    public static void randomizeArray(int[] array) {
        Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100);
		}
    }

    /**
     * Executes all the sorting algorithms for the arrays
     * Prints to stdout the results in a table
     * @param list
     */
    public static void executeAlgorithm(List<int[]> list) {
        long startTime;
        long endTime;
        long executionTime;

        /* Header of table */
        System.out.println("Array Size\t|\tMerge Sort\tQuick Sort\tRadix Sort\tHeap Sort");

        for (int[] array : list) {

            int[] duplicateArray;

            randomizeArray(array);
            
            /* Calls Merge Sort */

            System.out.print(array.length + "\t\t|");

            /* Start tracking time of algorithm */
            startTime = System.currentTimeMillis();

            /* Merge sort array in list */
            duplicateArray = Arrays.copyOf(array, array.length-1);
            MergeSort.mergeSort(duplicateArray);

            /* End time and calculate duration of sort algorithm */
            endTime = System.currentTimeMillis(); 
            executionTime = endTime - startTime;
            System.out.print("\t"+executionTime);

            /* Call Quick Sort */

            /* Start tracking time of algorithm */
            startTime = System.currentTimeMillis();

            /* Merge sort array in list */
            duplicateArray = Arrays.copyOf(array, array.length-1);
            QuickSort.quickSort(duplicateArray, 0, duplicateArray.length-1);

            /* End time and calculate duration of sort algorithm */
            endTime = System.currentTimeMillis(); 
            executionTime = endTime - startTime;
            System.out.print("\t\t"+executionTime);

            /* Call Radix Sort */

            /* Start tracking time of algorithm */
            startTime = System.currentTimeMillis();

            /* Merge sort array in list */
            duplicateArray = Arrays.copyOf(array, array.length-1);
            RadixSort.radixSort(duplicateArray);

            /* End time and calculate duration of sort algorithm */
            endTime = System.currentTimeMillis(); 
            executionTime = endTime - startTime;
            System.out.print("\t\t"+executionTime);

            /* Call Heap Sort */

            /* Start tracking time of algorithm */
            startTime = System.currentTimeMillis();

            /* Merge sort array in list */
            duplicateArray = Arrays.copyOf(array, array.length-1);
            HeapSort.heapSort(duplicateArray);

            /* End time and calculate duration of sort algorithm */
            endTime = System.currentTimeMillis(); 
            executionTime = endTime - startTime;
            System.out.print("\t\t"+executionTime + "\n");

            
        }
    }
}



