import java.util.Arrays;

public class Mergesort2 implements Sorter {

    private int[] data;

    @Override
    public int[] sort(int[] unsorted) {

        this.data = unsorted;

        this.mergesort(0, this.data.length - 1);

        return this.data;
    }

    private void mergesort(int low, int high) {

        int mid;

        if (low < high) {
            mid = (int) Math.floor((low + high) / 2);

            this.mergesort(low, mid);
            this.mergesort(mid + 1, high);
            this.merge(low, mid, high);
        }
    }

    private int[] merge(int low, int mid, int high) {

        int[] merged;
//        int bottomIndex, topIndex, mergedIndex;
        int i, j, k;

        merged = new int[low + 1 + high + 1];
        i = low;
        j = mid + 1;
        k = low;

        while (i <= mid && j <= high) {
            if (this.data[i] < this.data[j]) {
                merged[k] = this.data[i];

                i++;
            } else {
                merged[k] = this.data[j];

                j++;
            }

            k++;
        }

        if (i > mid) {
            // Copying the rest of the bottom
            System.arraycopy(this.data, j, merged, k, high - k);
        } else {
            // Copying the rest of the top
            System.arraycopy(this.data, i, merged, k, high - k);
        }

        // Copy the merged array to the data array
        System.arraycopy(merged, low, this.data, low, high - low);

        return merged;
    }

    public static void main(String[] args) {

        int[] test = {7, 5, 3, 2, 7, 4, 1, 3};
        Sorter sorter = new Mergesort2();
        int[] sorted = sorter.sort(test);

        System.out.println("Unsorted: " + Arrays.toString(test));
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}
