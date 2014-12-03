import java.util.Arrays;

public class InsertSort implements Sorter {

    @Override
    public int[] sort(int[] unsorted) {

        for (int i = 1; i <= unsorted.length; i++) {
            int x = unsorted[i];
            int j = i - 1;

            while (j >= 0 && (unsorted[j] > x)) {
                unsorted[j + 1] = unsorted[j];
                j--;
            }

            unsorted[j + 1] = x;
        }

        return unsorted;
    }

    public static void main(String[] args) {
        int[] test = {1, 5, 3};
        InsertSort merge = new InsertSort();
        int[] sorted = merge.sort(test);

        System.out.println("Unsorted: " + Arrays.toString(test));
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}
