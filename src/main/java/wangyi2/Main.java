package wangyi2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] q = new int[m];
        for (int i = 0; i < m; i++) {
            q[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int index = 0;
            int temp = q[i];
            while(temp > 0 && index < n) {
                temp -= a[index++];
            }
            System.out.println(index);
        }
    }

}
