package beike;

import java.util.HashMap;
import java.util.Scanner;

public class FamilyRelationship {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<Integer, Integer> relations = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (b == -1) {
                relations.put(a, b);
            } else {
                if (!relations.containsKey(a)) {
                    relations.put(a, b);
                } else {
                    relations.put(b, a);
                }
            }
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (isAncestor(relations, a, b)) {
                System.out.println(2);
            } else if (isAncestor(relations, b, a)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static boolean isAncestor(HashMap<Integer, Integer> relations, int a, int b) {
        int ancestorA = relations.get(a);
        while (ancestorA != -1) {
            if (b == ancestorA) {
                return true;
            }
            ancestorA = relations.get(ancestorA);
        }
        return false;
    }

}
