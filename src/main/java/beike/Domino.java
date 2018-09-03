package beike;

import java.util.HashMap;
import java.util.Scanner;

public class Domino {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] domino = new int[n];
        HashMap<Integer, Integer> property = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            int location = sc.nextInt();
            int height = sc.nextInt();

            domino[i] = location;
            property.put(location, height);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(getNumbers(i, domino, property));
        }
    }

    private static int getNumbers(int index, int[] domino, HashMap<Integer, Integer> property) {
        int[] result = new int[domino.length];
        result[index] = 1;
        for (int i = index; i < domino.length; i++) {
            if (result[i] == 1) {
                int influenceBegin = domino[i] + 1;
                int influenceEnd = domino[i] + property.get(domino[i]) - 1;
                for (int j = i + 1; j < domino.length; j++) {
                    if (domino[j] >= influenceBegin && domino[j] <= influenceEnd) {
                        result[j] = 1;
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }

        int count = 0;
        while (result[index++] == 1 && index < domino.length) {
            count++;
        }
        return count;
    }
}
