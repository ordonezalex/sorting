public class Mergesort implements Sorter {

    @Override
    public int[] sort(int[] unsorted) {

        if (unsorted.length > 1) {
            int bottomLength = (int) Math.floor(unsorted.length / 2);
            int topLength = unsorted.length - bottomLength;

            // Create bottom and top halves
            int[] bottom = new int[bottomLength];
            int[] top = new int[topLength];

            // Copy bottom half of array
            System.arraycopy(unsorted, 0, bottom, 0, bottom.length);

            // Copy top half of array
            System.arraycopy(unsorted, bottom.length, top, 0, top.length);

            bottom = sort(bottom);
            top = sort(top);

            unsorted = merge(bottom, top);
        }

        return unsorted;
    }

    private int[] merge(int[] bottom, int[] top) {
        int[] merged;
        int bottomIndex, topIndex, mergedIndex;

        merged = new int[bottom.length + top.length];
        bottomIndex = 0;
        topIndex = 0;
        mergedIndex = 0;

        while (topIndex < bottom.length && mergedIndex < top.length) {

            if (bottom[topIndex] < top[mergedIndex]) {
                merged[bottomIndex] = bottom[topIndex];

                topIndex++;
            } else {
                merged[bottomIndex] = top[mergedIndex];
                mergedIndex++;
            }

            bottomIndex++;
        }

        // Copying the rest of the array (either the bottom or the top rest is sorted)

        // Copying the rest of the bottom
        while (topIndex < bottom.length) {
            merged[bottomIndex] = bottom[topIndex];

            bottomIndex++;
            topIndex++;
        }

        // Copying the rest of the top
        while (mergedIndex < top.length) {
            merged[bottomIndex] = top[mergedIndex];

            bottomIndex++;
            mergedIndex++;
        }

        return merged;
    }
}
