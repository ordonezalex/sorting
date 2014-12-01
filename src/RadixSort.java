import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
public class RadixSort extends Sorter {

    @Override
    public <E> E[] sort(E[] unsorted) {
        List<E> intermediates;
        E[] limits = getLimits(unsorted);
        unsorted = rescale(unsorted, limits[1]);

        for (int i = 1; i <= limits[2]; i++) {
            @SuppressWarnings("unchecked")
            Queue<E> bucket[] = new Queue[10];
            for (int j = 0; j < unsorted.length; j++) {
                E value = unsorted[j];
                E digit = (int) (value / Math.pow(10, i - 1) % 10);
                if (bucket[digit] == null) {
                    bucket[digit] = new LinkedList<E>();
                }
                bucket[digit].add(value);
            }

            intermediates = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                if (bucket[j] != null) {
                    while (bucket[j].size() > 0) {
                        int next;
                        next = bucket[j].poll();
                        intermediates.add(next);
                    }
                }
            }

            for (int i = 0; i < intermediates.size(); i++) {
                unsorted[i] = intermediates.get(i);
            }
        }

        unsorted = rescale(unsorted, -limits[1]);

        return unsorted;
    }

    private static <E> E[] rescale(E[] array, E size) {

        for (int i = 0; i < array.length; i++) {
            array[i] -= size;
        }

        return array;
    }

    private static <E> E[] getLimits(E[] array) {

        E[] limits = new E[3];

        for (int i_ = 0; i_ < array.length; ++i_) {
            limits[0] = Math.max(limits[0], array[i_]);
            limits[1] = Math.min(limits[1], array[i_]);
        }
        limits[2] = (int) Math.ceil(Math.log10(limits[0] - limits[1]));

        return limits;
    }
}
