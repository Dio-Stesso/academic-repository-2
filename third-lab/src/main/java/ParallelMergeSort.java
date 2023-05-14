import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 * This class provides a parallel implementation of the merge sort algorithm
 * using the {@link RecursiveAction} class from the {@link java.util.concurrent}
 * package.
 *
 * <p>The {@code compute()} method is overridden to divide the input array into
 * two halves and sort each half in parallel using two instances of
 * {@code ParallelMergeSort}. The {@code merge()} method is then used to merge
 * the two sorted halves back together.
 */
public class ParallelMergeSort extends RecursiveAction {
    private final int[] array;
    private final int low;
    private final int high;

    /**
     * Constructs a new {@code ParallelMergeSort} object to sort the specified
     * range of the specified array.
     *
     * @param array the array to be sorted
     * @param low   the index of the first element (inclusive) to be sorted
     * @param high  the index of the last element (exclusive) to be sorted
     */
    public ParallelMergeSort(int[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    /**
     * Sorts the specified range of the array in parallel using the merge sort
     * algorithm.
     */
    @Override
    protected void compute() {
        if (high - low <= 1) {
            return;
        }
        int mid = (low + high) / 2;
        ParallelMergeSort left = new ParallelMergeSort(array, low, mid);
        ParallelMergeSort right = new ParallelMergeSort(array, mid, high);
        invokeAll(left, right);
        merge(array, low, mid, high);
    }

    /**
     * Merges two sorted halves of the specified range of the specified array.
     *
     * @param array the array containing the two halves to be merged
     * @param low   the index of the first element (inclusive) of the first half
     * @param mid   the index of the last element (exclusive) of the first half and
     *              the first element (inclusive) of the second half
     * @param high  the index of the last element (exclusive) of the second half
     */
    private void merge(int[] array, int low, int mid, int high) {
        int[] temp = Arrays.copyOfRange(array, low, high);
        int i = 0;
        int j = mid - low;
        for (int k = low; k < high; k++) {
            if (i >= mid - low) {
                array[k] = temp[j++];
            } else if (j >= high - low) {
                array[k] = temp[i++];
            } else if (temp[i] < temp[j]) {
                array[k] = temp[i++];
            } else {
                array[k] = temp[j++];
            }
        }
    }
}
