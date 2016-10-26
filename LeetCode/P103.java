/*
* @Author: GZhY
* @Date:   2016-10-19 14:53:54
* @Last Modified by:   GZhY
* @Last Modified time: 2016-10-21 14:07:06
*/

/**
 * Runtime: 2ms
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
            result.add(new LinkedList<Integer>());
        if(level%2 != 0)
            //result.get(level).listIterator().add(node.val); 3ms
            ((LinkedList<Integer>)result.get(level)).addFirst(node.val);
        else result.get(level).add(node.val);
        zigzagLevelRecursion(node.left, result, level + 1);
        zigzagLevelRecursion(node.right, result, level + 1);
    }
}