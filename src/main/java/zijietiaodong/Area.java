package zijietiaodong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 空气质量
 */
public class Area {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//采样点
        int t = scanner.nextInt();//小时数

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = scanner.nextInt();
        }

        int[] unSort = new int[n * t];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                unSort[i * n + j] = temp[j];
            }
        }
        int[] sorted = unSort;
        Arrays.sort(sorted);

        n = unSort.length;
        t = sorted.length;
        int[][] result = new int[n][t];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < t; j++) {
                if (unSort[i] == sorted[j]) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        System.out.println(result[n - 1][t - 1]);
    }
}