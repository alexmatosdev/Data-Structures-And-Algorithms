import java.util.Arrays;
import java.util.Collections;
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

    public static void randomizeArray(int[] array) {
        Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100);
		}

    }

    public static void executeAlgorithm(List<int[]> list) {
        long startTime;
        long endTime;
        long executionTime;

        /* Header of table */
        System.out.println("Array Size\t|\tMerge Sort\tQuick Sort");

        for (int[] array : list) {

            /* Calls Merge Sort */

            randomizeArray(array);

            System.out.print(array.length + "\t\t|");

            /* Start tracking time of algorithm */
            startTime = System.currentTimeMillis();

            /* Merge sort array in list */
            MergeSort.mergeSort(array);

            /* End time and calculate duration of sort algorithm */
            endTime = System.currentTimeMillis(); 
            executionTime = endTime - startTime;
            System.out.print("\t"+executionTime);

            /* Call Quick Sort */

            randomizeArray(array);

            /* Start tracking time of algorithm */
            startTime = System.currentTimeMillis();

            /* Merge sort array in list */
            QuickSort.quickSort(array, 0, array.length-1);

            /* End time and calculate duration of sort algorithm */
            endTime = System.currentTimeMillis(); 
            executionTime = endTime - startTime;
            System.out.print("\t\t"+executionTime + "\n");

            
        }
    }
}



