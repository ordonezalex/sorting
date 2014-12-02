public class InsertSort implements Sorter {

    @Override
    public int[] sort(int[] unsorted) {

        for (int i = 1; i <= unsorted.length; i++) {
            int x = unsorted[i];
            int j = i - 1;

            while (j >= 0 && (unsorted[j] > x)) {
                unsorted[j + 1] = unsorted[j];
                j--;
            }

            unsorted[j + 1] = x;
        }

        return unsorted;
    }
}
