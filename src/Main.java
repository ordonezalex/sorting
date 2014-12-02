import java.util.Random;

public class Main {

    /**
     * The size of data (after being multiplied by the `OUTER_ARRAY_SIZE` value.
     */
    private static final int INNER_ARRAY_SIZE = 100;
    /**
     * The amount of arrays of data that will be made. The first array will have data size of
     * `INNER_ARRAY_SIZE`, and each subsequent array will be one magnitude larger.
     */
    private static final int OUTER_ARRAY_SIZE = 4;

    public static void main(String[] args) {

        Sorter sorter;
        Random rand = new Random();

        // Set up random array of data
        int[][] unsorted = new int[OUTER_ARRAY_SIZE][];
        int[][] sorted;

        // Create arrays to hold unsorted data
        for (int i = 1; i < OUTER_ARRAY_SIZE; i++) {
            unsorted[i - 1] = new int[INNER_ARRAY_SIZE * i];

            // Randomly generate large amounts of data for each array
            for (int j = 0; j < INNER_ARRAY_SIZE * i; i++) {
                unsorted[i - 1][j] = rand.nextInt();
            }
        }

        // Sort using Binary Insert Sort
        System.out.println("Using Binary Insert Sort");
        sorter = new BinaryInsertSort();
        unsorted = Main.sort(sorter, unsorted);

        // Sort using Exchange Sort
        System.out.println("Using Exchange Sort");
        sorter = new ExchangeSort();
        unsorted = Main.sort(sorter, unsorted);

        // Sort using Heap Sort
        System.out.println("Using Heap Sort");
        sorter = new Heapsort();
        unsorted = Main.sort(sorter, unsorted);

        // Sort using Insert Sort
        System.out.println("Using Insert Sort");
        sorter = new InsertSort();
        unsorted = Main.sort(sorter, unsorted);

        // Sort using Mergesort
        System.out.println("Using Mergesort");
        sorter = new Mergesort();
        unsorted = Main.sort(sorter, unsorted);

        // Sort using Mergesort2
        System.out.println("Using Mergesort2");
        sorter = new Mergesort2();
        unsorted = Main.sort(sorter, unsorted);

        // Sort using Mergesort4
        System.out.println("Using Mergesort4");
        sorter = new Mergesort4();
        unsorted = Main.sort(sorter, unsorted);

        // Sort using Quicksort
        System.out.println("Using Quicksort");
        sorter = new Quicksort();
        unsorted = Main.sort(sorter, unsorted);

        // Sort using Quicksort2
        System.out.println("Using Quicksort2");
        sorter = new Quicksort2();
        unsorted = Main.sort(sorter, unsorted);

        // Sort using Radix Sort
        System.out.println("Using Radix Sort");
        sorter = new RadixSort();
        unsorted = Main.sort(sorter, unsorted);

        // Sort using Selection Sort
        System.out.println("Using Selection Sort");
        sorter = new SelectionSort();
        unsorted = Main.sort(sorter, unsorted);
    }

    private static int[][] sort(Sorter sorter, int[][] unsorted) {

        int[][] sorted = new int[unsorted.length][];

        for (int i = 0; i < unsorted.length; i++) {
            sorted[i] = sorter.sort(unsorted[i]);
        }

        return sorted;
    }
}
