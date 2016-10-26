/*
* @Author: GZhY
* @Time:   2016-10-26 21:20:43
* @Last Modified by:   GZhY
* @Last Modified time: 2016-10-26 21:21:30
*/

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null)
            if(q == null) return true;
            else return false;
        if(q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}