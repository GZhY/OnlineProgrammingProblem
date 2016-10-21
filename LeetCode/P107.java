/*
* @Author: GZhY
* @Date:   2016-10-19 14:51:47
* @Last Modified by:   GZhY
* @Last Modified time: 2016-10-21 14:07:17
*/

/**
 * Runtime: 1ms
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    private int maxLevel=0;
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        maxLevel = maxDepth(root)-1;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<= maxLevel; ++i)
            result.add(new ArrayList<Integer>());
        bottom_upLevelRecursion(root, result, 0);
        return result;
    }
    private int maxDepth(TreeNode root){   
        if (root == null) return 0;   
        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);
        if (leftdepth > rightdepth) return leftdepth + 1;   
        return rightdepth + 1;   
    }
    private void bottom_upLevelRecursion(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) return;
        result.get(maxLevel-level).add(node.val);
        bottom_upLevelRecursion(node.left, result, level + 1);
        bottom_upLevelRecursion(node.right, result, level + 1);
    }
}