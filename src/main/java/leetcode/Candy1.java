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
 * status:Time Limit Exceeded
 *
 * @Author lirf
 * @Date 2017/5/4 21:21
 */
public class Candy1 {
    public int candy(int[] ratings) {
        if (ratings.length == 1) return 1;
        int[] candys = new int[ratings.length];
        Arrays.fill(candys, 1);
        for (int i = 0; i < ratings.length; i++) {
            if (i == 0) {
                if (ratings[i] > ratings[i+1]) candys[i]++;
            } else if (i == ratings.length-1) {
                if (ratings[i] > ratings[i-1]) candys[i] += candys[i-1];
            } else {
                if (ratings[i] > ratings[i-1]) candys[i] += candys[i-1];
                if (ratings[i] > ratings[i+1] && candys[i] <= candys[i+1]) {
                    candys[i] += candys[i+1];
                    for (int j = i-1; j >= 0; j--) {
                        if (ratings[j] > ratings[j+1] && candys[j] <= candys[j+1]) {
                            candys[j]++;
                        } else {
                            break;
                        }
                    }
                }
            }
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
        int[] ratings = {5, 3, 4, 1};
        int result = candy(ratings);
        System.out.println(result);
    }
}
