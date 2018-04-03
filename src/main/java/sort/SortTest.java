package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 类的描述
 *
 * @Author lirf
 * @Date 2018/3/30 14:52
 */
public class SortTest {

    private int[] array = {6, 5, 3, 1, 8, 7, 2, 4, 9, 22, 10, 8, 26};

    @Test
    public void testBubble() {
        BubbleSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testSelection() {
        SelectionSort.selection(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testInsertion() {
        InsertionSort.insertion(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testQuick() {
        QuickSort.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        Arrays.sort();
    }
}
