package leetcode;

/**
 * Created by Li on 2017/3/17.
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            int j;
            int length = 0;
            boolean isbreak = false;
            for (j = i + 1; j < chars.length; j++) {
                for (int k = i; k < j; k++) {
                    if (chars[k] == chars[j]) {
                        length = j - i;
                        isbreak = true;
                        break;
                    }
                }
                if (isbreak) break;
            }
            if (j == chars.length && length == 0) {
                length = j - i;
            }
            if (length > result) {
                result = length;
            }
        }
        if (result == 0) return chars.length;
        return result;
    }

    public static void main(String[] args) {
        int length = LongestSubstring.lengthOfLongestSubstring("aucsfasd");
        System.out.println(length);
    }
}
