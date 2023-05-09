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
    List<List<Integer>> result = new ArrayList<>();
    int target = 0;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) {
            return result;
        }
        target = targetSum;
        helper(root);
        return result;
    }
    
    Stack<Integer> st = new Stack<>();
    int tempSum = 0;
    void helper(TreeNode root) {
        if(root.left==null && root.right==null) {
            tempSum += root.val;
            st.push(root.val);
            if(tempSum == target) {
                List<Integer> l = new ArrayList<>();
                for(Integer x : st) {
                    l.add(x);
                }
                result.add(l);
            }
            tempSum -= st.pop();
        }
        st.push(root.val);
        tempSum += root.val;
        if(root.left !=null) {
            helper(root.left);
        }
        if(root.right !=null) {
            helper(root.right);
        }
        tempSum -= st.pop();
    }
}