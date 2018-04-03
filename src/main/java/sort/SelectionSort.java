package sort;

/**
 * 选择排序算法
 * 最坏时间复杂度-----O(n*n)
 * 最好时间复杂度-----O(n*n)
 * 平均时间复杂度-----O(n*n)
 * 空间复杂度---------O(1)
 * 稳定性-------------不稳定，不稳定发生在最小元素与A[i]交换的时刻
 * 在性能上略优于冒泡排序
 *
 * @Author lirf
 * @Date 2018/3/30 14:47
 */
public class SelectionSort {

    public static void selection(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
}
