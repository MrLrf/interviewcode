package zijietiaodong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 类的描述
 *
 * @Author lirf
 * @Date 2018/9/9 10:47
 */
public class RestoreIP {

    /**
     * 对错误的ip地址还原
     * @param s
     * @return
     */
    public static List<String> restoreIpAddresses(String s) {
        List<String> ip = new ArrayList<>();
        StringBuilder tempIP = new StringBuilder();
        doRestore(0, tempIP, ip, s);
        return ip;
    }

    /**
     * 还原方法
     * @param k
     * @param tempIP
     * @param ip
     * @param s
     */
    private static void doRestore(int k, StringBuilder tempIP, List<String> ip, String s) {
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                ip.add(tempIP.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255) {
                if (tempIP.length() != 0) {
                    part = "." + part;
                }
                tempIP.append(part);
                doRestore(k + 1, tempIP, ip, s.substring(i + 1));
                tempIP.delete(tempIP.length() - part.length(), tempIP.length());
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        List<String> result = restoreIpAddresses(s);
        System.out.println(result.size());
    }
}
