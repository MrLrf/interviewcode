package zijietiaodong;

import java.util.*;

public class BreakThrough {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        int n = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> friends = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> friendNums = new ArrayList<>();
            int friendNum = sc.nextInt();
            while (friendNum != 0) {
                friendNums.add(friendNum);
                friendNum = sc.nextInt();
            }
            friends.put(i, friendNums);
        }
        int[] flag = new int[n + 1];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (flag[i] == 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                LinkedList<Integer> iterator = new LinkedList<>();
                ArrayList<Integer> fres = friends.get(i);
                temp.addAll(fres);
                iterator.addAll(fres);
                while (!iterator.isEmpty()) {
                    int num = iterator.remove();
                    if (flag[num] == 0) {
                        ArrayList<Integer> fre = friends.get(num);
                        iterator.addAll(fre);
                        temp.addAll(fres);
                    }
                    flag[num] = 1;
                }
                result.add(temp);
                flag[i] = 1;
            }
        }
        System.out.println(result);
    }

}
