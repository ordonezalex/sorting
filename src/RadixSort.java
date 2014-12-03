import java.util.*;

public class RadixSort implements Sorter {

    @Override
    public int[] sort(int[] unsorted) {

        List<Integer> intermediates;
        int[] limits = getLimits(unsorted);
        unsorted = rescale(unsorted, limits[1]);

        for (int i = 1; i <= limits[2]; i++) {
            Queue<Integer> bucket[] = new Queue[10];
            for (int j = 0; j < unsorted.length; j++) {
                int value = unsorted[j];
                int digit = (int) (value / Math.pow(10, i - 1) % 10);
                if (bucket[digit] == null) {
                    bucket[digit] = new LinkedList<Integer>();
                }
                bucket[digit].add(value);
            }

            intermediates = new ArrayList<Integer>();
            for (int j = 0; j < 10; j++) {
                if (bucket[j] != null) {
                    while (bucket[j].size() > 0) {
                        int next;
                        next = bucket[j].poll();
                        intermediates.add(next);
                    }
                }
            }

            for (int j = 0; j < intermediates.size(); j++) {
                unsorted[j] = intermediates.get(j);
            }
        }

        unsorted = rescale(unsorted, -limits[1]);

        return unsorted;
    }

    private static int[] rescale(int[] array, int size) {

        for (int i = 0; i < array.length; i++) {
            array[i] -= size;
        }

        return array;
    }

    private static int[] getLimits(int[] array) {

        int[] limits = new int[3];

        for (int i_ = 0; i_ < array.length; ++i_) {
            limits[0] = Math.max(limits[0], array[i_]);
            limits[1] = Math.min(limits[1], array[i_]);
        }
        limits[2] = (int) Math.ceil(Math.log10(limits[0] - limits[1]));

        return limits;
    }
}
