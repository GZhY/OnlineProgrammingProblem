/*
* @Author: GZhY
* @Date:   2016-11-09 23:46:58
* @Last Modified by:   GZhY
* @Last Modified time: 2016-11-09 23:51:23
*/

// Runtime:10ms Beats:24.54%
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return root == null ? 0 : ((root.left != null && root.left.left == null && root.left.right == null) ? root.left.val:sumOfLeftLeaves(root.left)) + sumOfLeftLeaves(root.right);
    }
}