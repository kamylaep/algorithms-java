package sort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    public List<Integer> sort(List<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            return arr;
        }

        List<Integer> sorted = new ArrayList<>();
        int size = arr.size();

        for (int i = 0; i < size; i++) {
            Integer smallest = findSmallestElement(arr);
            sorted.add(smallest);
            arr.remove(smallest);
        }
        return sorted;
    }

    private Integer findSmallestElement(List<Integer> arr) {
        Integer smallest = arr.get(0);
        for (Integer i : arr) {
            if (i < smallest) {
                smallest = i;
            }
        }
        return smallest;
    }
}
