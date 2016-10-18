/*
* @Author: zy
* @Date:   2016-10-18 22:27:45
* @Last Modified by:   zy
* @Last Modified time: 2016-10-19 00:21:51
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

	/**
	 * Runtime: 1 ms
	 */
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		levelRecursion(root, result, 0);
		return result;
	}

	private void levelRecursion(TreeNode node, List<List<Integer>> result, int level) {
		if (node == null) return;
		if (result.size() < level + 1) result.add(new ArrayList<Integer>());
		result.get(level).add(node.val);

		levelRecursion(node.left, result, level + 1);
		levelRecursion(node.right, result, level + 1);
	}
}