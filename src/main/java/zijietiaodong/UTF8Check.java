package zijietiaodong;

import java.util.Scanner;

/**
 * 类的描述
 *
 * @Author lirf
 * @Date 2018/9/9 10:53
 */
public class UTF8Check {

    public static boolean validUtf8(int[] data) {
        int count = 0;
        for (int num : data) {
            if (count == 0) {
                if ((num & 0x80) == 0) {
                    count = 0;
                } else if ((num & 0xe0) == 0xc0) {
                    count = 1;
                } else if ((num & 0xf0) == 0xe0) {
                    count = 2;
                } else if ((num & 0xf8) == 0xf0) {
                    count = 3;
                } else {
                    return false;
                }
            } else {
                if ((num & 0xc0) != 0x80) return false;
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[] data = new int[m];
        for (int i = 0; i < m; i++) {
            data[i] = in.nextInt();
        }
        boolean tag = validUtf8(data);
        if (tag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}

