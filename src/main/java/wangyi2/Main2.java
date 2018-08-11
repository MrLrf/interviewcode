package wangyi2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] heap = new int[n];
        for (int i = 0; i < n; i++) {
            heap[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] question = new int[m];
        int[] sumNum = new int[n];
        sumNum[0] = heap[0];
        for (int j = 1; j < heap.length; j++) {
            sumNum[j] = heap[j] + sumNum[j - 1];
        }

        for (int j = 0; j < m; j++) {
            question[j] = scanner.nextInt();
            System.out.println(mySort(sumNum, question[j]));
        }
    }

    private static int mySort(int[] v, int q) {
        int L = 0, R = v.length - 1;
        int ans = 0;
        while (L < R) {
            int mid = (L + R) / 2;
            if (v[mid] > q) {
                R = mid;
                ans = mid;
            } else if (v[mid] < q) {
                L = mid + 1;
                ans = mid + 1;
            } else {
                ans = mid;
                return ans + 1;
            }
        }
        return ans + 1;

    }

}