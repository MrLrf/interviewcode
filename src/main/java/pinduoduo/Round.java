package pinduoduo;

import java.util.Scanner;

public class Round {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int hp = sc.nextInt();
        int normalAttack = sc.nextInt();
        int bufferAttack = sc.nextInt();

        int attackNum = 0;

        if (normalAttack * 2 < bufferAttack) {
            int n = hp / bufferAttack;
            int residue = hp % bufferAttack;
            attackNum = n * 2;
            if (residue <= normalAttack) {
                ++attackNum;
            } else {
                attackNum += 2;
            }
        } else {
            attackNum = hp / normalAttack + 1;
        }

        System.out.println(attackNum);
    }

}
