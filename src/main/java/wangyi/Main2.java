package wangyi;

import java.util.Scanner;

/**
 * 类的描述
 *
 * @Author lirf
 * @Date 2018/3/29 13:54
 */
public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();

        long sum = 0;
        for (int i = 1; i <= l; i++) {
            sum += i;
        }

        int count = 0;
        for (int i = l + 1; i <= r; i++) {
            if (sum % 3 == 0) {
                count++;
            }
            sum += i;
        }
        if (sum % 3 == 0) {
            count++;
        }
        System.out.println(count);
    }

}
