public class BinaryInsertSort implements Sorter {

    @Override
    public int[] sort(int[] unsorted) {
        for (int i = 0; i < unsorted.length; i++) {
            int temp = unsorted[i];
            int left = 0;
            int right = i;
            while (left < right) {
                int middle = (left + right) / 2;
                if(temp >= unsorted[middle]) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }

            for (int j = i; j > left; j--) {
                int temp1 = unsorted[j - 1];
                unsorted[j - 1] = unsorted[j];
                unsorted[j] = temp1;
            }
        }
        return unsorted;
    }
}
