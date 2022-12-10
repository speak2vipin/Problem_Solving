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
    List<Long> totalList = new ArrayList<Long>();
    public int maxProduct(TreeNode root) {
        long mod = 1000000007;
        long total = totals(root);
        int size = totalList.size();
        long max = 0;
        for(int i=0; i<size; i++) {
            max = Math.max((total - totalList.get(i))*totalList.get(i), max);
        }
        return (int)(max%mod);
    }
    
    long totals(TreeNode root) {
        if(root==null) {
            return 0;
        }
        long left = totals(root.left);
        long right = totals(root.right);
        long subTotal = root.val + left + right;
        totalList.add(subTotal);
        return subTotal;
    }
    
    
}