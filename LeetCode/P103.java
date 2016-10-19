/*
* @Author: zy
* @Date:   2016-10-19 14:53:54
* @Last Modified by:   zy
* @Last Modified time: 2016-10-19 14:56:06
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        zigzagLevelRecursion(root, result, 0);
        return result;
    }
    private void zigzagLevelRecursion(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) return;
        if (result.size() < level + 1) 
            result.add(new ArrayList<Integer>());
        result.get(level).add(node.val);
        if(level%2 != 0){
            zigzagLevelRecursion(node.left, result, level + 1);
            zigzagLevelRecursion(node.right, result, level + 1);
        }else{
            zigzagLevelRecursion(node.right, result, level + 1);
            zigzagLevelRecursion(node.left, result, level + 1);
        }
    }
}