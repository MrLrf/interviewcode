package zijietiaodong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwoWorld {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            String[] strings = new String[n];
            for (int j = 0; j < n; j++) {
                strings[j] = sc.nextLine();
            }

            boolean result = false;
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isTwoWorld(strings[j], strings[k])) {
                        result = true;
                        break;
                    }
                }
            }

            String out = result ? "Yeah" : "Sad";
            System.out.println(out);
        }
    }

    protected static boolean isTwoWorld(String a, String b) {
        char[] char1 = a.toCharArray();
        char[] char2 = b.toCharArray();

        if (char1.length != char2.length) {
            return false;
        }
        int begin = a.indexOf(char2[0]);
        int index = 0;
        while (char1[begin] == char2[index]) {
            begin++;
            index++;
            if (begin == char1.length) {
                begin = 0;
            }
            if (index >= char2.length) {
                break;
            }
        }
        if (index >= char2.length) {
            return true;
        }
        index = 0;
        begin = a.indexOf(char2[0]);
        while (char1[begin] == char2[index]) {
            begin--;
            index++;
            if (begin == -1) {
                begin = char1.length - 1;
            }
            if (index >= char2.length) {
                break;
            }
        }
        if (index >= char2.length) {
            return true;
        }
        return false;
    }

}
