package sort;

public class MergeSort {

    public int[] sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    public void sort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            sort(arr, start, middle);
            sort(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }
    }

    public void merge(int[] arr, int start, int mid, int end) {
        int leftSize = mid - start + 1;
        int rightSize = end - mid;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            left[i] = arr[start + i];
        }

        for (int j = 0; j < rightSize; j++) {
            right[j] = arr[mid + 1 + j];
        }

        for (int i = 0, j = 0, k = start; k <= end; k++) {
            if ((j >= rightSize) || (i < leftSize && left[i] <= right[j])) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
        }
    }
}
