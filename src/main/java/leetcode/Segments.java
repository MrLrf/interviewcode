package leetcode;

/**
 * [LeetCode] Number of Segments in a String.
 * Count the number of segments in a string,
 * where a segment is defined to be a contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 *
 * @Author lirf
 * @Date 2017/5/19
 */
public class Segments {
    public static int countSegments(String s) {
        int result = 0;
        char[] segements = s.toCharArray();
//        if (segements.length == 1 && ((segements[0] >= 'a' && segements[0] <= 'z') || (segements[0] >= 'A' && segements[0] <= 'Z')))
//            result++;
        if (segements.length == 1 && segements[0] != ' ')
            result++;
        for (int i = 1; i < segements.length; i++) {
            char c1 = segements[i];
            char c2 = segements[i-1];
//            if ((c1 < 'A' || (c1 > 'Z' && c1 < 'a') || c1 > 'z') && (c1 != '\'') && (c1 != '-')
//                    && ((c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z'))) {
//                result++;
//            }
            if (c1 == ' ' && c2 != ' ') result++;
//            if (i == segements.length - 1 && ((c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z')))
//                result++;
            if (i == segements.length - 1 && c1 != ' ')
                result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
    }
}
