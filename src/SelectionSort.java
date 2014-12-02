public class SelectionSort implements Sorter {

    @Override
    public int[] sort(int[] unsorted) {

        for (int i = 0; i < unsorted.length - 1; i++) {
            int smallest = i;

            for (int j = i + 1; j < unsorted.length; j++) {
                if (unsorted[j] < unsorted[smallest]) {
                    smallest = j;
                }

                // Swap i and smallest
                int temp = unsorted[i];
                unsorted[i] = unsorted[smallest];
                unsorted[smallest] = temp;
            }
        }

        return unsorted;
    }
}
