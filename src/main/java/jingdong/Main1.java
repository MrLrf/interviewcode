package jingdong;

import java.util.*;

/**
 * 类的描述
 *
 * @Author lirf
 * @Date 2018/4/9 19:33
 */
public class Main1 {

    public static boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.toCharArray()[i] != s.toCharArray()[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int result = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (countMap.containsKey(chars[i])) {
                Integer c = countMap.get(chars[i]);
                countMap.replace(chars[i], ++c);
            } else {
                countMap.put(chars[i], 1);
            }
        }
        for (Character key : countMap.keySet()) {
            result += (Math.pow(2, countMap.get(key)) - 1);
        }

        if (isPalindrome(s)) result++;
        System.out.println(result);
    }

}
