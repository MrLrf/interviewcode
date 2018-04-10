package huawei;

import java.util.Scanner;

/**
 * 类的描述
 *
 * @Author lirf
 * @Date 2018/4/10 19:18
 */
public class Main2 {
    private static int jump(int[] steps) {
        int jmp = 0;
        int dest = steps.length - 1;

        while(dest != 0) {
            for(int i = 0; i < dest; i++) {
                if(i + steps[i] >= dest) {    // 说明从i位置能1步到达dest的位置
                    dest = i;                 // 更新dest位置，下一步就是计算要几步能调到当前i的位置
                    jmp++;
                    break;                    // 没必要再继续找，因为越早找到的i肯定越靠前，说明这一跳的距离越远
                }
            }
        }
        return jmp;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] steps = new int[n];
        for (int i = 0; i < n; i++) {
            steps[i] = sc.nextInt();
        }
        System.out.println(jump(steps)) ;
    }
}
