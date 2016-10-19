/*
* @Author: zy
* @Date:   2016-10-19 21:23:00
* @Last Modified by:   zy
* @Last Modified time: 2016-10-19 21:23:30
*/

/**
 * Runtime: 1 ms
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(leftDepth > rightDepth) return leftDepth + 1;
        return rightDepth + 1;
    }
}