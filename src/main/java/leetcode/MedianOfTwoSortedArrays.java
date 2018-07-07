package leetcode;

/**
 * Created by Li on 2017/3/17.
 */
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index = 0;
        int i = 0, j = 0;
        int length1 = nums1.length, length2 = nums2.length;
        int[] sum = new int[length1 + length2];
        double result;
        if (length1 <= length2) {
            for (; i < length1; ) {
                if (j >= length2) {
                    sum[index++] = nums1[i];
                    i++;
                    continue;
                }
                if (nums1[i] <= nums2[j]) {
                    sum[index++] = nums1[i];
                    i++;
                } else {
                    sum[index++] = nums2[j];
                    j++;
                }
            }
            for (int k = j; k < length2; k++) {
                sum[index++] = nums2[k];
            }
        } else {
            for (; i < length2; ) {
                if (j >= length1) {
                    sum[index++] = nums2[i];
                    i++;
                    continue;
                }
                if (nums2[i] <= nums1[j]) {
                    sum[index++] = nums2[i];
                    i++;
                } else {
                    sum[index++] = nums1[j];
                    j++;
                }
            }
            for (int k = j; k < length1; k++) {
                sum[index++] = nums1[k];
            }
        }
        if (sum.length % 2 != 0) {
            result = sum[(sum.length - 1) / 2];
        } else {
            int median = sum.length / 2 - 1;
            result = ((double) (sum[median] + sum[median + 1])) / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4};
        int[] nums2 = {1, 2};
        double median = MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}
