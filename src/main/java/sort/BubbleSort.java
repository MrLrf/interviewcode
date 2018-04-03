package sort;

/**
 * 冒泡排序算法
 * 最坏时间复杂度-----O(n*n)
 * 最好时间复杂度-----O(n)
 * 平均时间复杂度-----O(n*n)
 * 空间复杂度---------O(1)
 * 稳定性-------------稳定
 *
 * @Author lirf
 * @Date 2018/3/30 14:17
 */
public class BubbleSort {

    public static void bubbleSort(int[] array) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    flag = true;
                }
            }
        }
    }
}
