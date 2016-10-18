/*
* @Author: zy
* @Date:   2016-10-18 22:27:45
* @Last Modified by:   zy
* @Last Modified time: 2016-10-18 23:59:57
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
	/**
	 * Runtime: 3 ms
	 */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> intList = new ArrayList<>();
        if(root == null) return intList;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> level = new LinkedList<Integer>();
        queue.offer(root);
        level.offer(0);
        intList.add(new ArrayList<Integer>());
        while(!queue.isEmpty()){
        	TreeNode treeNode = queue.poll();
        	int currentLevel = level.poll();
        	if(currentLevel+1 > intList.size())
        		intList.add(new ArrayList<Integer>());
        	intList.get(currentLevel).add(treeNode.val);
        	if(treeNode.left != null) {
        		queue.offer(treeNode.left);
        		level.offer(currentLevel+1);
        	}
        	if(treeNode.right != null) {
        		queue.offer(treeNode.right);
        		level.offer(currentLevel+1);
        	}
        }
        return intList;
    }
}