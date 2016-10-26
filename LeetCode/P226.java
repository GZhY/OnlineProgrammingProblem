/*
* @Author: GZhY
* @Time:   2016-10-26 21:45:32
* @Last Modified by:   GZhY
* @Last Modified time: 2016-10-26 22:01:37
*/

// Runtime:1ms Beats:0.5%
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return root;
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }
}