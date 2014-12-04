public class Mergesort2 implements Sorter {

    @Override
    public int[] sort(int[] unsorted) {
        this.mergesort(unsorted, 0, unsorted.length - 1);
        return unsorted;
    }

    private void mergesort(int[] unsorted, int lo, int hi) {
        int low = lo;
        int high = hi;
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;

        //Partition the list into two lists and sort them recursively
        this.mergesort(unsorted, low, mid);
        this.mergesort(unsorted, mid + 1, high);

        //Merge the two sorted lists
        int end_lo = mid;
        int start_hi = mid + 1;
        while ((low <= end_lo) && (start_hi <= high)) {
            if (unsorted[low] < unsorted[start_hi]) {
                low++;
            } else {
                int T = unsorted[start_hi];
                for (int k = start_hi - 1; k >= low; k--) {
                    unsorted[k+1] = unsorted[k];
                }
                unsorted[low] = T;
                low++;
                end_lo++;
                start_hi++;
            }
        }
    }
}
