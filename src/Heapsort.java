public class Heapsort implements Sorter {
    @Override
    public <E> E[] sort(E[] unsorted) {
        for (int i = 0; i < unsorted.length; i++) {
            int n = i;
            while (n > 0) {
                int p = (n - 1) / 2;
                if (unsorted[n] > unsorted[p]) {
                    unsorted = arraySwap(unsorted, n, p);
                    n = p;
                } else {
                    break;
                }
            }
        }

        for(int i = unsorted.length; i > 0;) {
            arraySwap(unsorted, 0, --i);
            int n = 0;
            while(true) {
                int left = (n * 2) + 1;
                if(left >= i) {
                    break;
                }
                int right = left + 1;
                if(right >= i) {
                    if(unsorted[left] > unsorted[n]) {
                        unsorted = arraySwap(unsorted, left, n);
                    }
                    break;
                }
                if(unsorted[left] > unsorted[n]) {
                    if(unsorted[left] > unsorted[right]) {
                        unsorted = arraySwap(unsorted, left, n);
                        n = left;
                        continue;
                    } else {
                        unsorted = arraySwap(unsorted, right, n);
                        n = right;
                        continue;
                    }
                } else {
                    if (unsorted[right] > unsorted[n]) {
                        unsorted = arraySwap(unsorted, right, n);
                        n = right;
                        continue;
                    } else {
                        break;
                    }
                }
            }
        }
        return unsorted;
    }

    private <E> E[] arraySwap(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        return array;
    }
}
