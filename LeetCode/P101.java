/*
* @Author: GZhY
* @Time:   2016-10-26 23:22:52
* @Last Modified by:   GZhY
* @Last Modified time: 2016-10-26 23:25:30
*/

// Runtime:1ms Beats:21.3%
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        root.right = invertTree(root.right);
        return isSameTree(root.left, root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return root;
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null && p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}