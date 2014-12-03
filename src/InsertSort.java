public class InsertSort implements Sorter {

    @Override
    public int[] sort(int[] unsorted) {
        int j;
        int x;

        for (int i = 1; i < unsorted.length; i++) {
            x = unsorted[i];
            j = i - 1;

            while (j > 0 && (unsorted[j] > x)) {
                unsorted[j + 1] = unsorted[j];
                j--;
            }

            unsorted[j + 1] = x;
        }

        return unsorted;
    }
}
