/*
* @Author: GZhY
* @Time:   2016-10-26 21:20:43
* @Last Modified by:   GZhY
* @Last Modified time: 2016-10-26 22:00:39
*/

// Runtime:0ms Beats:19.68%
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p != null && q != null && p.val == q.val) 
        	return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    	return false;
    }
}