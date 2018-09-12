package xunlei;

import java.util.Scanner;

/**
 * 勾股数，是由三个正整数组成的数组；能符合勾股定理 a*a + b*b = c*c ，
 * (a, b, c) 的正整数解。如果 (a, b, c) 是勾股数，它们的正整数倍数，也是勾股数。
 * 如果 (a, b, c) 互质，它们就称为素勾股数。给定正整数N，
 * 计算出小于或等于N的素勾股数个数。(0 < a <= b <= c <= N)
 *
 * 输入：正整数N
 * 输出：小于或等于N的素勾股数个数 (0 < a <= b <= c <= N)
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        boolean isEnd = false;
        for (int u = 1; u <= Math.sqrt(n); ++u) {
            for (int v = u + 1; v <= Math.sqrt(n); v += 2) {
                if (gcd(u, v) == 1) {
                    int a = 2 * u * v;
                    int b = v * v - u * u;
                    int c = v * v + u * u;
                    if (a > n || b > n || c > n) {
                        isEnd = true;
                        break;
                    }
                    count++;
                    System.out.println(a + " " + b + " " + c);
                }
            }
            if (isEnd) {
                break;
            }
        }
        System.out.println(count);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
