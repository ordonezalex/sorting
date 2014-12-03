import java.util.Arrays;

public class Mergesort implements Sorter {

    @Override
    public int[] sort(int[] unsorted) {

        if (unsorted.length > 1) {
            System.out.println("Sorting " + Arrays.toString(unsorted));

            int bottomLength = (int) Math.floor(unsorted.length / 2);
            int topLength = unsorted.length - bottomLength;
            int j = 0;

            int[] bottom = new int[bottomLength];
            int[] top = new int[topLength];

            for (int i = 0; i < unsorted.length; i++) {
                if (i < bottomLength) {
                    // Copy bottom half of array
                    bottom[i] = unsorted[i];
                } else {
                    // Copy top half of array
                    top[j] = unsorted[i];
                    j++;
                }
            }

            System.out.println("Bottom is " + Arrays.toString(bottom));
            System.out.println("Top is " + Arrays.toString(top));

            bottom = sort(bottom);
            top = sort(top);

            System.out.println("Sorted bottom is " + Arrays.toString(bottom));
            System.out.println("Sorted top is " + Arrays.toString(top));

            unsorted = merge(bottomLength, topLength, bottom, top);
        }

        return unsorted;
    }

//    private void mergeSort(int[] unsorted, int size) {
//
//        if (unsorted.length > 1) {
//            int h = (int) Math.floor(unsorted.length / 2);
//            int m = unsorted.length - h;
//            int[] bottom = new int[h];
//            int[] top = new int[m];
//
//            for (int i = 0; i < unsorted.length; i++) {
//                if (i <= h) {
//                    bottom[i] = unsorted[i];
//                } else {
//                    top[i] = unsorted[i];
//                }
//            }
//        }
//    }

    private int[] merge(int bottomLength, int topLength, int[] bottom, int[] top) {

        System.out.println("Merging bottom " + Arrays.toString(bottom)
                + " and top " + Arrays.toString(top));

        int[] merged;
        int bottomIndex, topIndex, mergedIndex;

        merged = new int[bottomLength + topLength];
        bottomIndex = 0;
        topIndex = 0;
        mergedIndex = 0;

        while (bottomIndex < bottomLength && topIndex < topLength) {
            if (bottom[bottomIndex] <= top[bottomIndex]) {

                merged[mergedIndex] = bottom[bottomIndex];
                bottomIndex++;

                System.out.println("First merged is " + Arrays.toString(merged));
            } else {

                merged[mergedIndex] = top[topIndex];
                topIndex++;

                System.out.println("First merged is " + Arrays.toString(merged));
            }

            mergedIndex++;
        }
        System.out.println("Almost done..");

        // Copying the rest of the array (either the bottom or the top rest is sorted)
        // bottomIndex = 0;
        // topIndex = 0;
        if (bottomIndex < bottomLength) {
            // Copying the rest of the top

            while (topIndex < topLength) {
                System.out.println("Putting " + top[topIndex] + " to " + mergedIndex + " in " + Arrays.toString(merged));

                merged[mergedIndex] = top[topIndex];
                topIndex++;
                mergedIndex++;

                System.out.println("New merged is " + Arrays.toString(merged));
            }

        } else {
            // Copying the rest of the bottom
            while (bottomIndex < bottomLength) {
                System.out.println("Putting " + bottom[bottomIndex] + " to " + mergedIndex + " in " + Arrays.toString(merged));

                merged[mergedIndex] = bottom[bottomIndex];
                bottomIndex++;
                mergedIndex++;

                System.out.println("New merged is " + Arrays.toString(merged));
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] test = {1, 5, 3};
        Mergesort merge = new Mergesort();
        int[] sorted = merge.sort(test);

        System.out.println("Unsorted: " + Arrays.toString(test));
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}
