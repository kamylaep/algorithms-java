package recursion;

import java.util.Arrays;

public class Recursion {

    public int sum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        return arr[0] + sum(Arrays.copyOfRange(arr, 1, arr.length));
    }

    public int count(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        return 1 + count(Arrays.copyOfRange(arr, 1, arr.length));
    }

    public int max(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        if (arr.length == 1) {
            return arr[0];
        }

        int max = arr[0] > arr[1] ? arr[0] : arr[1];
        int tempMax = max(Arrays.copyOfRange(arr, 1, arr.length));
        return max > tempMax ? max : tempMax;
    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
