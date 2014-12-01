public class SelectionSort implements Sorter {

    @Override
    public <E extends Comparable<E>> E[] sort(E[] unsorted) {

        for (int i = 0; i < unsorted.length - 1; i++) {
            int smallest = i;

            for (int j = i + 1; j < unsorted.length; j++) {
                if (unsorted[j].compareTo(unsorted[smallest]) < 0) {
                    smallest = j;
                }

                // Swap i and smallest
                E temp = unsorted[i];
                unsorted[i] = unsorted[smallest];
                unsorted[smallest] = temp;
            }
        }

        return unsorted;
    }
}
