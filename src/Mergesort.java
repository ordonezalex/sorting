import java.lang.reflect.Array;

public class Mergesort<E> implements Sorter<E> {
    @Override
    public E[] sort(E[] unsorted) {
        if (unsorted.length > 1) {
            int h = (int) Math.floor(unsorted.length / 2), m = unsorted.length - h;
            E[] unsortedLeft = (E[]) Array.newInstance(unsorted, h);
        }
        return unsorted;
    }
}
