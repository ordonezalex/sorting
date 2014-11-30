public class InsertSort implements Sorter {

    @Override
    public <E> E[] sort(E[] unsorted) {

        for (int i = 2; i <= unsorted.length; i++) {
            E x = unsorted[i];
            int j = i - 1;

            while (j > 0 && unsorted[j] > x) {
                unsorted[j + 1] = unsorted[j];
                j--;
            }
            unsorted[j + 1] = x;
        }

        return unsorted;
    }
}
