package wangyi2;

import java.util.*;
import java.util.Scanner;

public class Directory {
    private static ArrayList<String> sort(String input) {
        ArrayList<String> sortList = new ArrayList<>();
        char leftChar = input.charAt(0);
        if (input.length() > 1) {
            String rightString = input.substring(1, input.length());
            List<String> rightStringSortedList = sort(rightString);
            rightStringSortedList.forEach((e) -> {
                for (int i = 0; i < e.length() + 1; i++) {
                    sortList.add(new StringBuffer(e).insert(i, leftChar).toString());
                }
            });
        } else {
            sortList.add(String.valueOf(leftChar));
        }
        return sortList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        if (k == 0) {
            System.out.println("-1");
            return;
        }
        char[] chars = new char[m + n];
        for (int i = 0; i < m; i++) {
            chars[i] = 'z';
        }
        for (int i = m; i < m + n; i++) {
            chars[i] = 'a';
        }
        String str = String.valueOf(chars);
        ArrayList<String> list = sort(str);
        TreeSet<String> treeSet = new TreeSet<>();
        if (k > list.size()) System.out.println("-1");
        for (int i = 0; i < list.size(); i++) {
            treeSet.add(list.get(i));
        }
        int index = 0;
        for (String string : treeSet) {
            if (index == k - 1) {
                System.out.println(string);
                return;
            } else index++;
        }
        System.out.println("-1");
    }
}
