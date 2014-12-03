public class Quicksort2 implements Sorter {
    @Override
    public int[] sort(int[] unsorted) {

        quicksortRecursive(unsorted, 0, unsorted.length - 1);

        return unsorted;
    }

    private void quicksortRecursive(int[] unsorted, int low, int high) {
        int index = partition(unsorted, low, high);

        // Recursively call quicksort with left part of the partitioned array
        if (low < index - 1) {
            quicksortRecursive(unsorted, low, index - 1);
        }

        // Recursively call quick sort with right part of the partitioned array
        if (high > index) {
            quicksortRecursive(unsorted, index, high);
        }
    }

    private int partition(int[] unsorted, int low, int high) {
        int pivot = unsorted[low]; // taking first element as pivot

        while (low <= high) {
            //searching number which is greater than pivot, bottom up
            while (unsorted[low] < pivot) {
                low++;
            }
            //searching number which is less than pivot, top down
            while (unsorted[high] > pivot) {
                high--;
            }

            // swap the values
            if (low <= high) {
                int tmp = unsorted[low];
                unsorted[low] = unsorted[high];
                unsorted[high] = tmp;

                //increment left index and decrement right index
                low++;
                high--;
            }
        }
        return low;
    }
}
