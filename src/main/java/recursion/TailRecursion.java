package recursion;

import java.util.Arrays;

public class TailRecursion {

    public int sum(int[] arr) {
        return sum(arr, 0);
    }

    private int sum(int[] arr, int total) {
        if (arr == null || arr.length == 0) {
            return total;
        }
        Integer pop = arr[0];
        return sum(Arrays.copyOfRange(arr, 1, arr.length), total + pop);
    }

    public int count(int[] arr) {
        return count(arr, 0);
    }

    private int count(int[] arr, int total) {
        if (arr == null || arr.length == 0) {
            return total;
        }

        return count(Arrays.copyOfRange(arr, 1, arr.length), total + 1);
    }

    public int factorial(int n) {
        return factorial(n, 1);
    }

    private int factorial(int n, int total) {
        if (n == 0) {
            return total;
        }

        return factorial(n - 1, total * n);
    }
}
