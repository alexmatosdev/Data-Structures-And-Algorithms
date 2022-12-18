public class HeapSort {

    public static int[] heapSort(int[] arr) {
		int parentNode;
		for (int j = 0; j < arr.length;j++) {
			int ex = 0;
			for (int i = 0; i < arr.length; i++) {
				parentNode = arr[(i-1)/2];
				if (parentNode > arr[i]) {
					int t = parentNode;
					arr[(i-1)/2] = arr[i];
					arr[i] = t;
					ex++;
				}
			}
			if (ex == 0)
				break;
		}
		return arr;
	}
}
