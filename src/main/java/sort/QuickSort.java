package sort;

import java.util.Arrays;

/**
 * 类的描述
 *
 * @Author lirf
 * @Date 2018/3/30 20:09
 */
public class QuickSort {

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = array[right];               // 这里每次都选择最后一个元素作为基准
        int tail = left - 1;                    // tail为小于基准的子数组最后一个元素的索引
        for (int i = left; i < right; i++) {    // 遍历基准以外的其他元素
            if (array[i] <= pivot) {            // 把小于等于基准的元素放到前一个子数组末尾
                swap(array, ++tail, i);
            }
        }
        swap(array, tail + 1, right);           // 最后把基准放到前一个子数组的后边，剩下的子数组既是大于基准的子数组
                                                  // 该操作很有可能把后面元素的稳定性打乱，所以快速排序是不稳定的排序算法
        return tail + 1;                    // 返回基准的索引
    }

    public static void quickSort(int[] array, int left, int right) {
        System.out.println(Arrays.toString(array));
        if (left >= right) {
            return;
        }
        int pivot_index = partition(array, left, right); // 基准的索引
        quickSort(array, left, pivot_index - 1);
        quickSort(array, pivot_index + 1, right);
    }

}
