package sort;

/**
 * 插入排序算法
 *
 * @Author lirf
 * @Date 2018/3/30 15:16
 */
public class InsertionSort {

    /**
     * 直接插入排序
     * 最坏时间复杂度-----O(n*n)
     * 最好时间复杂度-----O(n)
     * 平均时间复杂度-----O(n*n)
     * 空间复杂度---------O(1)
     * 稳定性-------------稳定
     * 在性能上略优于冒泡排序和选择排序
     * @param array
     */
    public static void insertion(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int get = array[i];
            int j = i - 1;
            for ( ; j >= 0; j--) {
                if (array[j] <= get) {
                    break;
                }
                array[j + 1] = array[j];
            }
            array[j + 1] = get;
        }
    }

    /**
     * 二分插入排序
     * 最坏时间复杂度-----O(n*n)
     * 最好时间复杂度-----O(nlogn)
     * 平均时间复杂度-----O(n*n)
     * 空间复杂度---------O(1)
     * 稳定性-------------稳定
     * 当n较大时，二分插入排序的比较次数比直接插入排序的最差情况好得多，但比直接插入排序的最好情况要差，
     * 所以当以元素初始序列已经接近升序时，直接插入排序比二分插入排序比较次数少。
     * 二分插入排序元素移动次数与直接插入排序相同，依赖于元素初始序列。
     * @param array
     */
    public static void insertionDichotomy(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int get = array[i];
            int left = 0;
            int right = i - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (array[mid] > get) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                array[j + 1] = array[j];
            }
            array[left] = get;
        }
    }




}
