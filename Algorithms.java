package by.htp.andersen_trainee.algorithms;

public class Algorithms {

	public static void main(String[] args) {

	}

	public static int simpleSearchMinElement(int[] arr) {
		int minIndex = 0;
		int min = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				minIndex = i;
			}
		}

		return minIndex;

	}

	public static int binarySearch(int[] arr, int item) {
		int low = 0;
		int high = arr.length - 1;

		int mid;
		int guess;

		while (low <= high) {
			mid = (low + high) / 2;
			guess = arr[mid];

			if (guess == item) {
				return mid;
			} else if (guess > item) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int index = i;
			int min = arr[i];

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < min) {
					index = j;
					min = arr[j];
				}
			}
			arr[index] = arr[i];
			arr[i] = min;
		}
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (arr.length == 0)
			return;

		if (low >= high)
			return;

		int mid = low + (high - low) / 2;
		int sup = arr[mid];

		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < sup) {
				i++;
			}

			while (arr[j] > sup) {
				j--;
			}

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		if (low < j)
			quickSort(arr, low, j);

		if (high > i)
			quickSort(arr, i, high);
	}

}
