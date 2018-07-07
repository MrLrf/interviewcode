package algorithm;

/**
 * 常用的排序算法
 */
public class AllSort {

    //----------------------冒泡排序----------------------//
    /**
     * 最坏时间复杂度-----O(n*n)
     * 最好时间复杂度-----O(n)
     * 平均时间复杂度-----O(n*n)
     * 空间复杂度--------O(1)
     * 稳定性-----------稳定
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    //----------------------直接插入排序----------------------//
    /**
     * 最坏时间复杂度-----O(n*n)
     * 最好时间复杂度-----O(n)
     * 平均时间复杂度-----O(n*n)
     * 空间复杂度---------O(1)
     * 稳定性-------------稳定
     * 在性能上略优于冒泡排序和选择排序
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int get = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] <= get) {
                    break;
                }
                array[j + 1] = array[j];
            }
            array[j + 1] = get;
        }
    }

    //----------------------二分插入排序----------------------//
    /**
     * 最坏时间复杂度-----O(n*n)
     * 最好时间复杂度-----O(nlogn)
     * 平均时间复杂度-----O(n*n)
     * 空间复杂度---------O(1)
     * 稳定性-------------稳定
     * 当n较大时，二分插入排序的比较次数比直接插入排序的最差情况好得多，但比直接插入排序的最好情况要差，
     * 所以当以元素初始序列已经接近升序时，直接插入排序比二分插入排序比较次数少。
     * 二分插入排序元素移动次数与直接插入排序相同，依赖于元素初始序列。
     *
     * @param array
     */
    public static void insertionDichotomySort(int[] array) {
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

    //----------------------希尔排序----------------------//
    /**
     * 最坏时间复杂度-----O(n*n)
     * 最好时间复杂度-----O(n)
     * 平均时间复杂度-----O(n*n)
     * 空间复杂度--------O(1)
     * 稳定性-----------不稳定
     */
    public static void shellSort(int[] array) {
        int length = array.length;
        int gap = 1;
        while (gap < length / 3) {
            gap = gap * 3 + 1;
        }

        for (; gap >= 1; gap = gap / 3) {
            for (int i = gap; i < length; i++) {
                int temp = array[i];
                int j = i - gap;
                for (; j >= 0; j -= gap) {
                    if (array[j] > temp) {
                        array[j + gap] = array[j];
                    }
                }
                array[j + gap] = temp;
            }
        }
    }

    //----------------------选择排序算法----------------------//
    /**
     * 最坏时间复杂度-----O(n*n)
     * 最好时间复杂度-----O(n*n)
     * 平均时间复杂度-----O(n*n)
     * 空间复杂度---------O(1)
     * 稳定性-------------不稳定，不稳定发生在最小元素与A[i]交换的时刻
     * 在性能上略优于冒泡排序
     *
     * @param array
     */
    public static void selectionSort(int[] array) {
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

    //----------------------归并排序算法----------------------//
    /**
     * 最坏时间复杂度-----O(n*logn)
     * 最好时间复杂度-----O(n*logn)
     * 平均时间复杂度-----O(n*logn)
     * 空间复杂度---------O(n)
     * 稳定性-------------稳定
     *
     * @param array
     */
    public static void mergeSort(int[] array) {
        recursiveMerge(array, 0, array.length - 1);
    }

    /**
     * 归并排序递归分支
     *
     * @param array
     * @param left
     * @param right
     */
    private static void recursiveMerge(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;
        recursiveMerge(array, left, middle);
        recursiveMerge(array, middle + 1, right);
        merge(array, left, middle, right);
    }

    /**
     * 归并排序合并两个有序数组
     *
     * @param array
     * @param left
     * @param middle
     * @param right
     */
    private static void merge(int[] array, int left, int middle, int right) {
        int[] result = new int[right - left + 1];
        int index = 0;
        int i = left;
        int j = middle + 1;
        while (i <= middle && j <= right) {
            if (array[i] < array[j]) {
                result[index++] = array[i++];
            } else {
                result[index++] = array[j++];
            }
        }

        while (i <= middle) {
            result[index++] = array[i++];
        }
        while (j <= right) {
            result[index++] = array[j++];
        }

        for (int k = 0; k < result.length; k++) {
            array[k + left] = result[k];
        }
    }

    //----------------------快速排序算法----------------------//
    /**
     * 最坏时间复杂度-----O(n*n)
     * 最好时间复杂度-----O(n*logn)
     * 平均时间复杂度-----O(n*logn)
     * 空间复杂度---------O(n*logn)递归调用消耗的空间
     * 稳定性-------------不稳定
     *
     * @param array
     */
    public static void quickSort(int[] array) {
        int right = array.length - 1;
        partition(array, 0, right);
    }

    /**
     * 划分方法
     * @param array
     * @param left
     * @param right
     */
    private static void partition(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int temp = array[left];
        int i = left, j = right;

        while (i != j) {
            while (j > i && array[j] >= temp) {
                j--;
            }

            while (i < j && array[i] <= temp) {
                i++;
            }

            if (i < j) {
                swap(array, i, j);
            }
        }

        swap(array, left, i);
        partition(array, left, i - 1);
        partition(array, i + 1, right);
    }

    /**
     * 交换数组中两个位置的数字
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //----------------------堆排序算法(大根堆)----------------------//
    /**
     * 最坏时间复杂度-----O(n*logn)
     * 最好时间复杂度-----O(n*logn)
     * 平均时间复杂度-----O(n*logn)
     * 空间复杂度---------O(1)递归调用消耗的空间
     * 稳定性-------------不稳定
     * @param array
     */
    public static void heapSort(int[] array) {
        int length = array.length;

        //构建大根堆
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, length);
        }

        //交换跟节点与最后一个叶子结点&调整大根堆
        for (int i = length - 1; i >= 0; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i);
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param array
     * @param start
     * @param end
     */
    private static void adjustHeap(int[] array, int start, int end) {
        int temp = array[start];
        int i = start * 2 + 1;
        while (i < end) {
            if (i + 1 < end && array[i] < array[i + 1]) {
                i++;
            }
            if (array[i] > temp) {
                array[start] = array[i];
                start = i;
                i = i * 2 + 1;
            } else {
                break;
            }
        }
        array[start] = temp;
    }
}
