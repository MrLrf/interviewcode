package leetcode;

/**
 * Created by Li on 2017/2/22.
 */
public class TwoSum {
    public static int [] twoSum (int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int [] result = {i, j};
                    return result;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int [] nums_ = {-1,-2,-3,-4,-5};
        int target = -8;
        int [] result = twoSum(nums_, target);
        System.out.print(result[0] + ", " + result[1]);
    }
}
