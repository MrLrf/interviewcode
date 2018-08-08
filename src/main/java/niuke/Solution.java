package niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){

            int size = q.size();
            ArrayList<Integer> sublist = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
                sublist.add(temp.val);


            }
            res.add(sublist);

        }

        return res;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
