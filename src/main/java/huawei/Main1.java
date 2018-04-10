package huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 类的描述
 *
 * @Author lirf
 * @Date 2018/4/10 19:04
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        char[] chars = s.toCharArray();
        Map<Character, Integer> charCount = new HashMap<>(s.length());

        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (charCount.containsKey(chars[i])) {
                charCount.replace(chars[i], charCount.get(chars[i]) + 1);
                if (charCount.get(chars[i]) > max) {
                    max = charCount.get(chars[i]);
                }
            } else {
                charCount.put(chars[i], 1);
            }
        }
        Object[] sortedChars = charCount.keySet().toArray();
        Arrays.sort(sortedChars);
        StringBuffer result = new StringBuffer();
        while (max > 0) {
            for (int i = 0; i < sortedChars.length; i++) {
                if (charCount.get(sortedChars[i]) > 0) {
                    result.append(sortedChars[i]);
                    charCount.replace((Character) sortedChars[i], charCount.get(sortedChars[i]) - 1);
                } else {
                    continue;
                }
            }
            max--;
        }
        System.out.println(result);
    }

}
