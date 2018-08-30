package pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class RepeatingDecimals {
    final static int MAX = 3005;
    static int cx[] = new int[MAX];
    static int fs[] = new int[MAX];

    public static void main(String[] args) {
        int n, m, t, i;
        int cou = 0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        cou = 0;
        Arrays.sort(cx);
        Arrays.sort(fs);
        t = n;
        while (true) {
            t = t % m * 10;
            fs[cou] = t / m;
            for (i = 0; i < cou; ++i)
                if (cx[i] == t) break;
            if (i != cou) break;
            cx[cou++] = t;
        }

        int cycleNum = fs[i+1] == 0 ? cou - i - 1 : cou - i;
        System.out.println(i + " " + cycleNum);
    }


}