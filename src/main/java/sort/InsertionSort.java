package sort;

public class InsertionSort {


    public int[] sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > curr) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr;
        }

        return arr;
    }
}
