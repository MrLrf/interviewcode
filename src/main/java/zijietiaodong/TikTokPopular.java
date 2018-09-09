package zijietiaodong;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 类的描述
 *
 * ·@Author lirf
 * @Date 2018/9/9 11:03
 */
public class TikTokPopular {
    public static int getRedPersonsNum(int[][] data, int m, int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (isRedPerson(data, i, m, n)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static boolean isRedPerson(int[][] data, int cur, int m, int n) {
        HashSet fans = new HashSet();
        getAllFans(fans, data, cur, cur, 0, m, n);
        if (fans.size() == n - 1) {
            return true;
        } else {
            return false;
        }
    }

    private static void getAllFans(HashSet fans, int[][] data, int cur, int now, int num, int m, int n) {
        for (int i = 0; i < m; i++) {
            if (data[i][1] == cur && data[i][0] != now) {
                boolean tag = fans.add(data[i][0]);
                if (tag) {
                    getAllFans(fans, data, data[i][0], now, fans.size(), m, n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] data = new int[m][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                data[i][j] = in.nextInt();
            }
        }
        System.out.println(getRedPersonsNum(data, m, n));
    }
}
