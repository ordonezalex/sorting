import java.util.Random;

public class Main {

    /**
     * The size of the data (after being multiplied by 10 to the `OUTER_ARRAY_SIZE`th power).
     */
    private static final int INNER_ARRAY_SIZE = 100;
    /**
     * The amount of arrays of data that will be made. The first array will have data size of
     * `INNER_ARRAY_SIZE`, and each subsequent array will be one magnitude larger.
     */
    private static final int OUTER_ARRAY_SIZE = 4;
    /**
     * The amount of times to sort each array.
     */
    private static final int TIMES_TO_RUN = 1;

    public static void main(String[] args) {

        Sorter sorter;
        Random rand = new Random();

        for (int i = 0; i < TIMES_TO_RUN; i++) {
            // Set up random array of data
            int[][] unsorted = new int[OUTER_ARRAY_SIZE][];
            int[][] sorted;

            // Create arrays to hold unsorted data
            for (int j = 1; j <= OUTER_ARRAY_SIZE; j++) {
                unsorted[j - 1] = new int[INNER_ARRAY_SIZE];

                // Randomly generate large amounts of data for each array
                for (int k = 0; k < 10; k++) {
                    unsorted[j - 1][k] = rand.nextInt();
                }
            }

            // Sort using Binary Insert Sort
            System.out.println("Using Binary Insert Sort");
            sorter = new BinaryInsertSort();
            sorted = Main.sort(sorter, unsorted);

            // Sort using Exchange Sort
            System.out.println("Using Exchange Sort");
            sorter = new ExchangeSort();
            sorted = Main.sort(sorter, unsorted);

            // Sort using Heap Sort
            System.out.println("Using Heap Sort");
            sorter = new Heapsort();
            sorted = Main.sort(sorter, unsorted);

            // Sort using Insert Sort
            System.out.println("Using Insert Sort");
            sorter = new InsertSort();
            sorted = Main.sort(sorter, unsorted);

            // Sort using Mergesort
            System.out.println("Using Mergesort");
            sorter = new Mergesort();
            sorted = Main.sort(sorter, unsorted);

            // Sort using Mergesort2
            System.out.println("Using Mergesort2");
            sorter = new Mergesort2();
            sorted = Main.sort(sorter, unsorted);

            // Sort using Mergesort4
            System.out.println("Using Mergesort4");
            sorter = new Mergesort4();
            sorted = Main.sort(sorter, unsorted);

            // Sort using Quicksort2
            System.out.println("Using Quicksort2");
            sorter = new Quicksort2();
            sorted = Main.sort(sorter, unsorted);

            // Sort using Quicksort
            System.out.println("Using Quicksort");
            sorter = new Quicksort();
            sorted = Main.sort(sorter, unsorted);

            // Sort using Radix Sort
            System.out.println("Using Radix Sort");
            sorter = new RadixSort();
            sorted = Main.sort(sorter, unsorted);

            // Sort using Selection Sort
            System.out.println("Using Selection Sort");
            sorter = new SelectionSort();
            sorted = Main.sort(sorter, unsorted);
        }

        // Sorting beyond this point could take days.

        /*
         * 1. Create unsorted data of each magnitude (e.g. 1000, 10000, ...)
         * 2. Sort the data using each Sorter
         * 3. Repeat for TIMES_TO_RUN
         *
         * This is better (more time and code efficient) than:
         * 1. Create unsorted data of each magnitude (e.g. 1000, 10000, ...)
         * 2. Sort the data using a Sorter for TIMES_TO_RUN
         * 3. Repeat for each Sorter
         */
//        for (int i = 0; i < TIMES_TO_RUN; i++) {
//            // Set up random array of data
//            int[][] unsorted = new int[OUTER_ARRAY_SIZE][];
//            int[][] sorted;
//
//            // Create arrays to hold unsorted data
//            for (int j = 1; j <= OUTER_ARRAY_SIZE; j++) {
//                System.out.println("Creating array for " + (j - 1) + " of size " + (int) (INNER_ARRAY_SIZE * Math.pow(10, j)));
//                unsorted[j - 1] = new int[(int) (INNER_ARRAY_SIZE * Math.pow(10, j))];
//
//                // Randomly generate large amounts of data for each array
//                for (int k = 0; k < INNER_ARRAY_SIZE * j; k++) {
//                    unsorted[j - 1][k] = rand.nextInt();
//                }
//            }
//
//            // Sort using Binary Insert Sort
////            System.out.println("Using Binary Insert Sort");
////            sorter = new BinaryInsertSort();
////            sorted = Main.sort(sorter, unsorted);
//
//            // Sort using Exchange Sort
////            System.out.println("Using Exchange Sort");
////            sorter = new ExchangeSort();
////            sorted = Main.sort(sorter, unsorted);
//
//            // Sort using Heap Sort
////            System.out.println("Using Heap Sort");
////            sorter = new Heapsort();
////            sorted = Main.sort(sorter, unsorted);
//
//            // Sort using Insert Sort
//            System.out.println("Using Insert Sort");
//            sorter = new InsertSort();
//            sorted = Main.sort(sorter, unsorted);
//
//            // Sort using Mergesort
////            System.out.println("Using Mergesort");
////            sorter = new Mergesort();
////            sorted = Main.sort(sorter, unsorted);
//
//            // Sort using Mergesort2
////            System.out.println("Using Mergesort2");
////            sorter = new Mergesort2();
////            sorted = Main.sort(sorter, unsorted);
//
//            // Sort using Mergesort4
////            System.out.println("Using Mergesort4");
////            sorter = new Mergesort4();
////            sorted = Main.sort(sorter, unsorted);
//
//            // Sort using Quicksort2
////            System.out.println("Using Quicksort2");
////            sorter = new Quicksort2();
////            sorted = Main.sort(sorter, unsorted);
//
//            // Sort using Quicksort
////            System.out.println("Using Quicksort");
////            sorter = new Quicksort();
////            sorted = Main.sort(sorter, unsorted);
//
//            // Sort using Radix Sort
////            System.out.println("Using Radix Sort");
////            sorter = new RadixSort();
////            sorted = Main.sort(sorter, unsorted);
//
//            // Sort using Selection Sort
//            System.out.println("Using Selection Sort");
//            sorter = new SelectionSort();
//            sorted = Main.sort(sorter, unsorted);
//        }
    }

    private static int[][] sort(Sorter sorter, int[][] unsorted) {

        long[] sortingDurations = new long[OUTER_ARRAY_SIZE];
        int[][] sorted = new int[unsorted.length][];

        for (int i = 0; i < unsorted.length; i++) {
            long starting, ending, duration;

            System.gc();
            starting = System.nanoTime();

            sorted[i] = sorter.sort(unsorted[i]);

            ending = System.nanoTime();
            duration = ending - starting;

            // Add the duration of this run for this magnitude to its corresponding total
            sortingDurations[i] += duration;
        }

        for (int i = 0; i < unsorted.length; i++) {
            System.out.println("Data of size " + (int) (INNER_ARRAY_SIZE * Math.pow(10, i)) + " took " + (sortingDurations[i] / TIMES_TO_RUN));
        }

        return sorted;
    }
}
