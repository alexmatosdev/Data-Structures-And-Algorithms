import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
    
    /**
	 * Implementation of Radix Sort
	 * 
     * @param a
     * @return
     */
    public static int[] radixSort(int[] arr) {
		int max = -1;
		int passed=0;

		for (int x : arr){
			if (x > max){
				max= new Integer(x);
			}
		}
		while (max != 0) {
			ArrayList<Integer>[] bucket = new ArrayList[10];
			for (int i = 0; i < 10; i++) {
				bucket[i] = new ArrayList<>();
			}
			for (int i = 0; i < arr.length; i++) {
				if (passed == 0) {
					int bi = arr[i]%10;
					bucket[bi].add(arr[i]);
				}
				else {
					int bi = arr[i]/10;
					bucket[bi].add(arr[i]);
				}
			}
			int index = 0;
			for (int i = 0; i < bucket.length;i++){
				for (int j = 0;j < bucket[i].size(); j++){
					if (bucket[i].get(j) != null) {
						arr[index++] = bucket[i].get(j);
					}
				}
			}
			max /= 10;
			passed++;
		}
		return arr;
	}
}
