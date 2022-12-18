public class QuickSort {
    
    public static void main(String[] args) {

      int[] arr = {2,47,3,5,8,1};

      quickSort(arr, 0, arr.length-1);

      for (int i =0; i <  arr.length; i++) {
        System.out.println(arr[i]);
      }

    }

    public static int[] quickSort(int[] arr, int f, int l) {
		if (l > f) {
			int pi = partition(arr,f,l);
			quickSort(arr,f,pi-1);
			quickSort(arr,pi+1,l);
		}
		
		return arr;
	}

	// Finds numbers bigger and  smaller than pivot and swaps them
	private static int partition(int[] arr, int f, int l) {
		int p = arr[f], li = f + 1, hi = l;
		while (hi > li) {
			while (li <= hi && arr[li] <= p)
				li++;
			while (li <= hi && arr[hi] > p)
				hi--;

			if (hi > li) {
				int t = arr[hi];
				arr[hi] = arr[li];
				arr[li] = t;
			}
		}
		while (hi > f && arr[hi] >= p)
			hi--;
		if (p > arr[hi]) {
			arr[f] = arr[hi];
			arr[hi] = p;
			return hi;
		}
		else {
			return f;
		}
	}
}
