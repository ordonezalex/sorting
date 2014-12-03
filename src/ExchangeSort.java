public class ExchangeSort implements Sorter {

    @Override
    public int[] sort(int[] unsorted) {

        for (int i = 0; i < unsorted.length; i++) {
            for (int j = i + 1; j < unsorted.length; j++) {
                if (unsorted[i] > unsorted[j]) {

                    // Swap i and j
                    int temp = unsorted[i];
                    unsorted[i] = unsorted[j];
                    unsorted[j] = temp;
                }
            }
        }

        return unsorted;
    }
}
