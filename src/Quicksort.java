import java.util.Arrays;

public class Quicksort implements Sorter {

    int[] unsorted;
    @Override
    public int[] sort(int[] array) {
        unsorted = array;
        quicksort(0, unsorted.length - 1);
        return unsorted;
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot = unsorted[i + (j - i) / 2];

        while (i <= j) {
            while (unsorted[i] < pivot) {
                i++;
            }
            while (unsorted[j] > pivot) {
                j--;
            }
            if (i <= j) {
                //exchange numbers
                int temp = unsorted[i];
                unsorted[i] = unsorted[j];
                unsorted[j] = temp;

                i++;
                j--;
            }
        }

        if (low < j) {
            quicksort(low, j);
        }
        if (i < high) {
            quicksort(i, high);
        }
    }
}
