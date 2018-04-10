package huawei;

import java.util.Scanner;

/**
 * 类的描述
 *
 * @Author lirf
 * @Date 2018/4/10 20:31
 */
public class RightMain3 {

    public static String multiply(String A, String B) {
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();

        int[] results = new int[charsA.length + charsB.length];
        for (int i = 0; i < charsA.length; i++){
            for (int j = 0; j < charsB.length; j++) {
                results[i+j] += (charsA[i] - '0') * (charsB[j] - '0');
            }
        }
        for (int i = results.length -1; i > 0; i--) {
            results[i-1] += results[i] / 10;
            results[i] = results[i] % 10;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < results.length - 1; i++) {
            result.append(results[i]);
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
