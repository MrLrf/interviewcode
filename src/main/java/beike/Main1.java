package beike;

import java.util.*;

public class Main1 {
    /**
     * 多米诺骨牌
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] location = new int[n];
        for (int i = 0; i < n; i++) {
            int item = scanner.nextInt();
            location[i] = item;
            int height = scanner.nextInt();
            map.put(item, height);
        }
        int index = 0;
        for (int item : location) {
            int left = item;
            int right = item + map.get(item) - 1;
            location[index] = 0;
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> next = iterator.next();
                Integer key = next.getKey();
                if (key >= left && key <= right) {
                    location[index]++;
                    int comp = key + next.getValue() -1;
                    right = right > comp ? right : comp;
                }
            }
            System.out.print(location[index] + " ");
            index++;
        }
    }
}