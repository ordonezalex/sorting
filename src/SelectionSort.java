public class SelectionSort<E> implements Sorter<E> {
    @Override
    public E[] sort(E[] unsorted) {
        for (int i = 1; i <= unsorted.length - 1; i++) {
            int smallest = i;
            for (int j = i +1; j <= unsorted.length; j++) {
                if (unsorted[j] < unsorted[smallest]) {
                    smallest = j;
                }
                E temp = unsorted[i];
                unsorted[i] = unsorted[smallest];
                unsorted[smallest] = temp;
            }
        }
        return unsorted;
    }
}
