package wangyi;

import java.util.Scanner;

/**
 * 朴素的做法是枚举n^2个点然后跟k作比较。这显然对n<=100000的规模来说是不允许通过的。
 * 注意到当除数是y时，当x=1~n时，余数是1,2,3,...,y-1,0循环出现，循环节长度显然是y
 * 那么我们可以枚举y=k~n(当y<k时所有余数均小于k，因此不需要考虑)
 * 然后对于x=1~n，总共出现了[n/y]个循环节，然后数出每个循环节里面不小于k的余数。
 * 最后再数出不满一个循环节的不小于k的余数，就是答案了。注意当k=0的时候由于余数0出现在循环的末尾，因此要特别判断。
 * 复杂度为O(n)
 *
 * @Author lirf
 * @Date 2018/3/29 14:14
 */
public class Main5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long sum = 0;
        int t = 0;
        int tt = 0;
        for (int i = k + 1; i <= n; i++) {
            t++;
            tt = (n % i - k + 1) > 0 ? (n % i - k + 1) : 0;
            sum += n / i * t + tt;
        }
        if (k == 0) sum -= n;// k=0 特殊情况  多计算了n次
        System.out.print(sum);

    }
}
