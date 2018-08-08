package niuke;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();

        int len1 = first.length();
        int len2 = second.length();
        if (len1 < 1 || len2 < 1) {
            System.out.println(0);
            return;
        }

        int temp[][] = new int[len1][len2];
        int longest = 0;
        char[] char1 = first.toCharArray();
        char[] char2 = second.toCharArray();
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                temp[i][j] = 0;
            }
        }

        for (int i = 0; i < len1; i++) {
            if (char1[i] == char2[0])
                temp[i][0] = 1;
        }

        for (int i = 0; i < len2; i++) {
            if (char1[0] == char2[i])
                temp[0][i] = 1;
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (char1[i] == char2[j]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                }
            }
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (temp[i][j] > longest)
                    longest = temp[i][j];
            }
        }
        System.out.println(longest);
    }

}
