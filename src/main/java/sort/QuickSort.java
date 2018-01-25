package sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    public List<Integer> sort(List<Integer> arr) {
        if (arr == null) {
            return arr;
        }
        if (arr.size() < 2) {
            return new ArrayList<>(arr);
        }

        int pivot = arr.remove(0);

        List<Integer> right = new ArrayList<>();
        List<Integer> left = new ArrayList<>();

        for (Integer i : arr) {
            if (i <= pivot) {
                right.add(i);
            } else {
                left.add(i);
            }
        }

        List<Integer> sorted = new ArrayList<>();
        sorted.addAll(sort(right));
        sorted.add(pivot);
        sorted.addAll(sort(left));

        return sorted;
    }
}
