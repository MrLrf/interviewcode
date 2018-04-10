package jingdong;

import java.util.Scanner;

/**
 * 类的描述
 *
 * @Author lirf
 * @Date 2018/4/9 20:13
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int[] numbers = new int[t];
        for (int i = 0; i < t; i++) {
            numbers[i] = sc.nextInt();
        }

        int[] result = new int[t];
        for (int index = 0; index < t; index++) {
            result[index] = 0;
            for (int i = 1; i <= numbers[index] / 2; i += 2) {
                if (numbers[index] % i == 0 && (numbers[index] / i) % 2 == 0) {
                    result[index] = i;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            if (result[i] != 0) {
                System.out.println(result[i] + " " + numbers[i] / result[i]);
            } else {
                System.out.println("No");
            }
        }
    }

}
