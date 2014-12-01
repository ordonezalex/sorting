import java.lang.reflect.Array;

public class Mergesort implements Sorter {

    @Override
    public <E extends Comparable<E>> E[] sort(E[] unsorted) {

        if (unsorted.length > 1) {
            int h = (int) Math.floor(unsorted.length / 2), m = unsorted.length - h;
            E[] unsortedLeft = (E[]) Array.newInstance(unsorted.getClass(), h);
        }

        return unsorted;
    }
}
