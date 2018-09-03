package beike;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int count = 0;
        while(n != m) {
            int planA = n - 1;
            int planB = n * 2;
            int distanceA = Math.abs(planA - m);
            int distanceB = Math.abs(planB - m);

            if (distanceA > distanceB) {
                n = planB;
            } else {
                n = planA;
            }
            count++;
        }

        System.out.println(count);
    }
}
