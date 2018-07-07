import algorithm.AllSort;
import algorithm.QuickSort;
import org.junit.Test;

import java.util.Arrays;

public class SortTest {

    private int[] array = {6, 5, 3, 1, 8, 7, 2, 4, 9, 22, 10, 8, 26};
//    private int[] array = {49, 38, 65, 97, 76, 13, 27};

    @Test
    public void testBubble() {
        AllSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testSelection() {
        AllSort.selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testInsertion() {
        AllSort.insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testQuickSort() {
        QuickSort.quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testMergeSort() {
        AllSort.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testHeapSort() {
        AllSort.heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
