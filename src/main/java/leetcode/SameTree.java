package leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 * @Author lirf
 * @Date 2017/5/22
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //非递归的二叉树前序遍历
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null)) return false;
        Stack<TreeNode> stack1 =  new Stack<TreeNode>();
        Stack<TreeNode> stack2 =  new Stack<TreeNode>();
        stack1.add(p);
        stack2.add(q);
        while (!stack1.empty() && !stack2.empty()) {
            TreeNode t1 = stack1.pop();
            TreeNode t2 = stack2.pop();
            System.out.println("遍历节点:" + t1.val + ", " + t2.val);
            if (t1.val != t2.val) return false;
            if ((t1.left == null && t2.left != null) || (t1.right == null && t2.right != null) ||
            (t1.left == null && t2.left != null) || (t1.right == null && t2.right != null)) return false;
            if (t1.right != null)
                stack1.add(t1.right);
            if (t1.left != null)
                stack1.add(t1.left);
            if (t2.right != null)
                stack2.add(t2.right);
            if (t2.left != null)
                stack2.add(t2.left);
        }
        return true;
    }

    @Test
    public void solution () {
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(1);

        TreeNode p1 = new TreeNode(2);
        TreeNode q1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        TreeNode q2 = new TreeNode(3);

        p.left = p1;
        p.right = p2;
        q.left = q1;
        q.right = q2;

        System.out.println(isSameTree(p, q));
    }
}
