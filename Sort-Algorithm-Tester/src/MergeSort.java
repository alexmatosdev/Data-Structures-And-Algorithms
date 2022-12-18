public class MergeSort {
    
    public static int[] mergeSort(int[] arr) {
		int index = 0;
		
		if (arr.length > 1) {

            /* Gets the first half of the array */
			int[]fh = new int[arr.length/2];
			for (int i = 0; i < arr.length/2;i++) {
				fh[i] = arr[i];
            }

            /* Recursive call */
			mergeSort(fh);

            /* Gets second half of the array */
			int[] sh = new int[arr.length - arr.length / 2];
			for (int i = arr.length/2; i < arr.length; i++) {
				sh[index] = arr[i];
				index++;
			}

            /* Recursive call */
			mergeSort(sh);

            /* Steps into merge function */
			merge(fh,sh,arr);
		}
		return arr;
	}

	/*
     * Merges the first or second half of the array
     */
	public static void merge(int[] fh, int[] sh, int[] arr) {
        int i = 0;
        int j = 0;
        int t= 0; 
        int length = fh.length;

        /* overwrites original array with the sored array*/
		while (i < length && j < length) {
			if (fh[i] < sh[j]) {
				arr[t] = fh[i];
                t++;
                i++;
			} else {
				arr[t] = sh[j]; 
                t++; 
                j++;
			}
		}
		while (i < length) {
			arr[t] = fh[i]; 
            t++; 
            i++;
		}
		while (j < length) {
			arr[t] = sh[j]; 
            t++; 
            j++;
		}
	}
}
