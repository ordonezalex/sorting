import java.util.Arrays;

public class Mergesort implements Sorter {

    @Override
    public int[] sort(int[] unsorted) {

        if (unsorted.length > 1) {
//            System.out.println("Sorting " + Arrays.toString(unsorted));

            int bottomLength = (int) Math.floor(unsorted.length / 2);
            int topLength = unsorted.length - bottomLength;

            // Create bottom and top halves
            int[] bottom = new int[bottomLength];
            int[] top = new int[topLength];

            // Copy bottom half of array
            System.arraycopy(unsorted, 0, bottom, 0, bottom.length);

            // Copy top half of array
            System.arraycopy(unsorted, bottom.length, top, 0, top.length);

//            System.out.println("Bottom is " + Arrays.toString(bottom));
//            System.out.println("Top is " + Arrays.toString(top));

            bottom = sort(bottom);
            top = sort(top);

//            System.out.println("Sorted bottom is " + Arrays.toString(bottom));
//            System.out.println("Sorted top is " + Arrays.toString(top));

            unsorted = merge(bottom, top);
        }

        return unsorted;
    }

    private int[] merge(int[] bottom, int[] top) {

//        System.out.println("Merging bottom " + Arrays.toString(bottom)
//                + " and top " + Arrays.toString(top));

        int[] merged;
        int bottomIndex, topIndex, mergedIndex;

        merged = new int[bottom.length + top.length];
        bottomIndex = 0;
        topIndex = 0;
        mergedIndex = 0;

        while (topIndex < bottom.length && mergedIndex < top.length) {
//            System.out.println("i is " + bottomIndex + " and bottom is " + bottom.length);
//            System.out.println("j is " + topIndex + " and top is " + top.length);

            if (bottom[topIndex] < top[mergedIndex]) {
                merged[bottomIndex] = bottom[topIndex];

                topIndex++;

//                System.out.println("First merged is " + Arrays.toString(merged));
            } else {

                merged[bottomIndex] = top[mergedIndex];

                mergedIndex++;

//                System.out.println("First merged is " + Arrays.toString(merged));
            }

            bottomIndex++;

//            System.out.println("i is " + bottomIndex + " and bottom is " + bottom.length);
//            System.out.println("j is " + topIndex + " and top is " + top.length);
        }

        // Copying the rest of the array (either the bottom or the top rest is sorted)

        // Copying the rest of the bottom
        while (topIndex < bottom.length) {
            merged[bottomIndex] = bottom[topIndex];

            bottomIndex++;
            topIndex++;

//            System.out.println("New merged is " + Arrays.toString(merged));
        }

        // Copying the rest of the top
        while (mergedIndex < top.length) {
            merged[bottomIndex] = top[mergedIndex];

            bottomIndex++;
            mergedIndex++;

//            System.out.println("New merged is " + Arrays.toString(merged));
        }

        return merged;
    }

    public static void main(String[] args) {

        int[] test = {7, 5, 3, 2, 7, 4, 1, 3};
        Sorter sorter = new Mergesort();
        int[] sorted = sorter.sort(test);

        System.out.println("Unsorted: " + Arrays.toString(test));
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}
