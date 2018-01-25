package search;

public class BinarySearch {

    public int search(int[] searchElements, int findElement) {
        int low = 0;
        int high = searchElements.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            int guess = searchElements[middle];

            if (guess == findElement) {
                return middle;
            } else if (guess > findElement) {
                high = middle - 1;
            } else if (guess < findElement) {
                low = middle + 1;
            }
        }
        return -1;
    }

}