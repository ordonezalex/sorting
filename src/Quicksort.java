public class Quicksort<E> implements Sorter<E> {
    private E[] unsorted;
    @Override
    public E[] sort(E[] array) {
        unsorted = array;
        int left = 0;
        int right = unsorted.length - 1;
        quickSort(left, right);
        return unsorted;
    }

    private void quickSort(int left,int right) {
        if(left >= right) {
            return;
        }

        int pivot = unsorted[right];
        int partition = partition(left, right, pivot);

        quickSort(0, partition-1);
        quickSort(partition+1, right);
    }
    private int partition(int left,int right,int pivot) {
        int leftCursor = left - 1;
        int rightCursor = right;
        int temp;

        while(leftCursor < rightCursor) {
            while(unsorted[++leftCursor] < pivot);
            while(rightCursor > 0 && unsorted[--rightCursor] > pivot);
            if(leftCursor >= rightCursor) {
                break;
            } else {
                temp = leftCursor;
                leftCursor = rightCursor;
                rightCursor = temp;
            }

        }

        temp = leftCursor;
        leftCursor = right;
        right = temp;

        return leftCursor;
    }
}
