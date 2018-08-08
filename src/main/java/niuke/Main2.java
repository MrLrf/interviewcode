package niuke;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s1 = sc.nextLine().toCharArray();
        char[] s2 = sc.nextLine().toCharArray();
        int max = 0;
        int[] dp = new int[s2.length + 1];
        dp[0] = 0;
        for (int i = 0; i < s1.length; ++i) {
            for (int j = dp.length - 1; j >= 1; --j) {
                if (s1[i] == s2[j - 1]) dp[j] = dp[j - 1] + 1;
                else dp[j] = 0;
                if (dp[j] > max) max = dp[j];
            }
        }
        System.out.println(max);
    }

}
