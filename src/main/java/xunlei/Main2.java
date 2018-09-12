package xunlei;

import java.util.Scanner;

/**
 * 有红黑两种颜色的方块积木，红色代表正数A，黑色代表负数B。
 * 选出17块积木排成一排，使得任意相邻7块积木之和都小于0。
 * 如何挑选才能使17块积木之和最大，最大值是多少？
 * <p>
 * 输入：正数A，负数B（A和B绝对值小于10000）
 * 输出：积木之和的最大值
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int red = in.nextInt();
        int black = in.nextInt();
        System.out.println(getSum(red, -black));
    }

    private static int getSum(int red, int black) {
        int blackNum = 7 * red / (black + red) + 1;
        int redNum = 7 - blackNum;
        int num = 2;
        int rest = 3;
        int sum = (red * redNum - black * blackNum) * num;
        if (rest > redNum) {
            blackNum = rest - redNum;
        } else {
            blackNum = 0;
            redNum = rest;
        }
        sum += red * redNum - black * blackNum;
        return sum;
    }
}