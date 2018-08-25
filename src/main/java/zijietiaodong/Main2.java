package zijietiaodong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 空气质量
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//采样点
        int t = scanner.nextInt();//小时数
        scanner.nextLine();
        String onehour = scanner.nextLine(); //一个小时内的
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(onehour + " ");
        }
        String s = sb.toString();
        String[] unsort = s.split(" ");
        String[] sorted = s.split(" ");
        Arrays.sort(sorted, Comparator.comparingInt(Integer::parseInt));
        System.out.println(unsort);
        System.out.println(sorted);
        n = unsort.length;
        t = sorted.length;
        int[][] result = new int[n][t];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < t; j++) {
                if(unsort[i].equals(sorted[j])){
                    result[i][j] = result[i-1][j-1] + 1;
                }else {
                    result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
                }
            }
        }
        System.out.println(result[n-1][t-1]);
    }
}
