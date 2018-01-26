package sort;

import java.util.Arrays;

public class CountingSort {

    public int[] sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int[] temp = new int[max + 1];

        for (int i : arr) {
            temp[i] += 1;
        }

        int curr = 0;

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i]; j++) {
                arr[curr] = i;
                curr++;
            }
        }

        return arr;
    }
}
