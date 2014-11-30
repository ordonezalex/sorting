public class ExchangeSort<E> implements Sorter<E> {
    @Override
    public E[] sort(E[] unsorted) {
        for (int i = 1; i <= unsorted.length; i++) {
           for (int j = i + 1; j <= unsorted.length; j++) {
                if (unsorted[j] < unsorted[i]) {
                    E temp = unsorted[i];
                    unsorted[i] = unsorted[j];
                    unsorted[j] = temp;
                }
           }
        }
        return unsorted;
    }
}
