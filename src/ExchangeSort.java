public class ExchangeSort implements Sorter {

    @Override
    public <E> E[] sort(E[] unsorted) {

        for (int i = 1; i <= unsorted.length; i++) {
            for (int j = i + 1; j <= unsorted.length; j++) {
                if (unsorted[j] < unsorted[i]) {

                    // Swap i and j
                    E temp = unsorted[i];
                    unsorted[i] = unsorted[j];
                    unsorted[j] = temp;
                }
            }
        }

        return unsorted;
    }
}
