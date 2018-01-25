package sort;

public class BubbleSort {

    public int[] sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            boolean somethingSorted = false;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    continue;
                }

                somethingSorted = true;
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }

            if (!somethingSorted) {
                break;
            }
        }

        return arr;
    }
}
