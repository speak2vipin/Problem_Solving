/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
		List<Double> list = new ArrayList<Double>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		double sum = 0.0;
	
		while (!q.isEmpty()) {
			int count = q.size();
			for (int i = 0; i < count; i++) {
				TreeNode temp = q.poll();
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
				sum += temp.val;
				
			}
			//average = sum / count;
			list.add(sum / count);
            sum=0.0;
		}
		return list;
    }
}