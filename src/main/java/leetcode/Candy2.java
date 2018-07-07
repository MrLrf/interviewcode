package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * [LeetCode] Candy.
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * status:Accepted
 *
 * @Author lirf
 * @Date 2017/5/10 21:21
 */
public class Candy2 {
    public int candy(int[] ratings) {
        if (ratings.length == 1) return 1;
        int[] candys = new int[ratings.length];
        Arrays.fill(candys, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1] && candys[i] <= candys[i-1]) candys[i] = candys[i-1] + 1;
        }
        for (int j = ratings.length - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j+1] && candys[j] <= candys[j+1]) candys[j] = candys[j+1] + 1;
        }
        int result = 0;
        System.out.println(Arrays.toString(candys));
        for (int i = 0; i < candys.length; i++) {
            result += candys[i];
        }
        return result;
    }

    @Test
    public void test() {
        int[] ratings = {5, 3, 1};
        int result = candy(ratings);
        System.out.println(result);
    }
}
