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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> childSet = new HashSet<>();
        for(int d[] : descriptions) {
            TreeNode parent = map.getOrDefault(d[0], new TreeNode(d[0]));
            TreeNode child = map.getOrDefault(d[1], new TreeNode(d[1]));
            if(d[2]==1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            map.put(d[0], parent);
            map.put(d[1], child);
            childSet.add(d[1]);
        }
        
        for(int d[] : descriptions) {
            if(!childSet.contains(d[0])) {
                return map.get(d[0]);
            }
        }
        return null;
    }
}