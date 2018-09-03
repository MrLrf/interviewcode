package beike;

import java.util.Scanner;

public class Calculator2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int res = 0;
        if (m > n) {
            System.out.println(m - n);
            return;
        }
        if (m == n) {
            System.out.println(0);
            return;
        }
        int p = n + 1;
        p *= 2;
        while (m < p / 2) {
            res++;
            p = p / 2;
        }
        res = res + m - p / 2;
        if (n % 2 == 0) System.out.println(res);
        else System.out.println(res + 1);

    }

}