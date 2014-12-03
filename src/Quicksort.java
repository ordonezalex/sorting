import java.util.Arrays;

public class Quicksort implements Sorter {

    private int[] data;

    @Override
    public int[] sort(int[] unsorted) {

        this.data = unsorted;
        quickSort(0, this.data.length - 1);

        return this.data;
    }

    private void quickSort(int low, int high) {

        if (high > low) {
            int pivot = data[high];

            partition(low, high, pivot);

            System.out.println("Sorting from " + low + " to " + (pivot - 1));
            quickSort(low, pivot - 1);

            System.out.println("Sorting from " + (pivot + 1) + " to " + high);
            quickSort(pivot + 1, high);
        } else {
            System.out.println("High is not greater than low");
        }
    }

    private int partition(int low, int high, int pivot) {

        // First item is pivot
        int pivotItem = this.data[low];

        System.out.println("Pivot is " + low);
        System.out.println("Pivot item is " + pivotItem);

        int temp;
        int lowIndex = low;

        System.out.println("Comparing from [" + (lowIndex + 1) + " to " + high + "]");

        for (int i = lowIndex + 1; i <= high; i++) {
            System.out.println("Comparing items at " + lowIndex + " and " + i);
            System.out.println("Comparing items " + this.data[lowIndex] + " and " + this.data[i]);

            if (this.data[i] < pivotItem) {
                System.out.println("Datum at " + i + " is less than pivot item");

                System.out.println("Swapping items at " + i + " and " + lowIndex);
                System.out.println("Swapping " + this.data[i] + " and " + this.data[lowIndex]);

                temp = this.data[i];
                this.data[i] = this.data[lowIndex];
                this.data[lowIndex] = temp;

                lowIndex++;
            }
        }

        System.out.println("Swapping items at " + low + " and " + lowIndex);
        System.out.println("Swapping " + this.data[low] + " and " + this.data[lowIndex]);

        temp = this.data[low];
        this.data[low] = this.data[pivot];
        this.data[pivot] = temp;

        System.out.println("New pivot is " + pivot);

        return pivot;
    }

    public static void main(String[] args) {

        Sorter sorter = new Quicksort();

        int[] unsorted = new int[] {3, 4, 5, 2, 1};
        System.out.println("Unsorted: " + Arrays.toString(unsorted));

        int[] sorted;
        sorted = sorter.sort(unsorted);
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}
