/*
* @Author: GZhY
* @Time:   2016-10-26 23:22:52
* @Last Modified by:   GZhY
* @Last Modified time: 2016-10-26 23:54:19
*/


public class Solution {

	// Runtime:0ms Beats:95.48%
	private boolean isSymmetric(TreeNode node1, TreeNode node2) {
	    return node1 == null && node2 == null || node1 != null && node2 != null && node1.val == node2.val && isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
	}
	public boolean isSymmetric(TreeNode root) {
	    return root == null || isSymmetric(root.left, root.right);
	}	

	// Runtime:1ms Beats:21.3%	
    // public boolean isSymmetric(TreeNode root) {
    //     if (root == null || root.left == null && root.right == null) return true;
    //     root.right = invertTree(root.right);
    //     return isSameTree(root.left, root.right);
    // }

    // public TreeNode invertTree(TreeNode root) {
    //     if (root == null || root.left == null && root.right == null) return root;
    //     TreeNode temp = invertTree(root.left);
    //     root.left = invertTree(root.right);
    //     root.right = temp;
    //     return root;
    // }

    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     if (p == null && q == null) return true;
    //     if (p != null && q != null && p.val == q.val)
    //         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    //     return false;
    // }
}