/*
* @Author: zy
* @Date:   2016-10-18 22:27:45
* @Last Modified by:   zy
* @Last Modified time: 2016-10-18 23:45:25
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> intList = new ArrayList<>();
        if(root == null) return intList;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<int> level = new LinkedList<TreeNode>();
        queue.offer(root);
        intList.add(new ArrayList<Integer>());
        while(!queue.isEmpty()){
        	TreeNode treeNode = queue.poll();
        	if(currentLevel+1 > intList.size())
        		intList.add(new ArrayList<Integer>());
        	intList.get(currentLevel).add(treeNode.val);
        	if(treeNode.left != null) queue.offer(treeNode.left);
        	if(treeNode.right != null) queue.offer(treeNode.right);
        	if(treeNode.left!=null || treeNode.right != null) currentLevel++;
        }
        return intList;
    }
}