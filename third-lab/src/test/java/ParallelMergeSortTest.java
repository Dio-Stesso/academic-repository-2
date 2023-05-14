import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import org.junit.jupiter.api.Test;

public class ParallelMergeSortTest {
    private static final int SIZE = 1000000;
    private static final int MAX_VALUE = 10000;
    private static final Random RANDOM = new Random();

    @Test
    public void testEmptyArray() {
        int[] array = {};
        int[] expected = {};

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelMergeSort(array, 0, array.length));

        assertArrayEquals(expected, array);
    }

    @Test
    public void testParallelMergeSort() {
        int[] array = createRandomArray();
        int[] expected = array.clone();
        Arrays.sort(expected);

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelMergeSort(array, 0, array.length));

        assertArrayEquals(expected, array);
    }

    @Test
    public void testSingleElementArray() {
        int[] array = {1};
        int[] expected = {1};

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelMergeSort(array, 0, array.length));

        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelMergeSort(array, 0, array.length));

        assertArrayEquals(expected, array);
    }

    @Test
    public void testReverseSortedArray() {
        int[] array = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelMergeSort(array, 0, array.length));

        assertArrayEquals(expected, array);
    }

    @Test
    public void testSequentialMergeSort() {
        int[] array = createRandomArray();
        int[] expected = array.clone();
        Arrays.sort(expected);

        mergeSort(array, 0, array.length);

        assertArrayEquals(expected, array);
    }

    // Time measurement
    public static void main(String[] args) {
        int[] array1 = createRandomArray();
        int[] array2 = array1.clone();

        long startTime1 = System.nanoTime();
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelMergeSort(array1, 0, array1.length));
        long endTime1 = System.nanoTime();

        long startTime2 = System.nanoTime();
        mergeSort(array2, 0, array2.length);
        long endTime2 = System.nanoTime();

        double elapsedTime1 = (endTime1 - startTime1) / 1000000000.0;
        double elapsedTime2 = (endTime2 - startTime2) / 1000000000.0;

        System.out.println("Parallel: " + elapsedTime1 + " seconds");
        System.out.println("Sequential: " + elapsedTime2 + " seconds");
    }

    private static void mergeSort(int[] array, int low, int high) {
        if (high - low <= 1) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
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

    private static int[] createRandomArray() {
        int[] array = new int[ParallelMergeSortTest.SIZE];
        for (int i = 0; i < ParallelMergeSortTest.SIZE; i++) {
            array[i] = RANDOM.nextInt(MAX_VALUE);
        }
        return array;
    }
}
