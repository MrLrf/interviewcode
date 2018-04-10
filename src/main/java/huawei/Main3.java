package huawei;

import java.util.Scanner;

/**
 * 类的描述
 *
 * @Author lirf
 * @Date 2018/4/10 19:27
 */
public class Main3 {

    public static String multiply(String A, String B) {
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();

        int[][] results = new int[charsA.length + 1][charsB.length];
        int x = 0;
        int y = 0;
        for (int i = charsA.length - 1; i >= 0; i--) {
            int a = charsA[i] - 48;
            int offset = 0;
            for (int j = charsB.length - 1; j >= 0; j--) {
                int b = charsB[j] - 48;
                int temp = a * b + offset;
                offset = temp / 10;
                results[x++][y] = temp % 10;
            }
            x = 0;
            y++;
        }
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int length = results.length > results[0].length ? results.length : results[0].length;
        for (int j = 0; j < length; j++) {
            int sum = carry;
            for (int i = 0; i < results.length; i++) {
                if (j - i >= 0 && j - i < results[i].length) {
                    sum += results[i][j - i];
                } else {
                    continue;
                }
            }
            result.insert(0, (sum % 10));
            carry = sum / 10;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();

        System.out.println(multiply(A, B));
    }
}
