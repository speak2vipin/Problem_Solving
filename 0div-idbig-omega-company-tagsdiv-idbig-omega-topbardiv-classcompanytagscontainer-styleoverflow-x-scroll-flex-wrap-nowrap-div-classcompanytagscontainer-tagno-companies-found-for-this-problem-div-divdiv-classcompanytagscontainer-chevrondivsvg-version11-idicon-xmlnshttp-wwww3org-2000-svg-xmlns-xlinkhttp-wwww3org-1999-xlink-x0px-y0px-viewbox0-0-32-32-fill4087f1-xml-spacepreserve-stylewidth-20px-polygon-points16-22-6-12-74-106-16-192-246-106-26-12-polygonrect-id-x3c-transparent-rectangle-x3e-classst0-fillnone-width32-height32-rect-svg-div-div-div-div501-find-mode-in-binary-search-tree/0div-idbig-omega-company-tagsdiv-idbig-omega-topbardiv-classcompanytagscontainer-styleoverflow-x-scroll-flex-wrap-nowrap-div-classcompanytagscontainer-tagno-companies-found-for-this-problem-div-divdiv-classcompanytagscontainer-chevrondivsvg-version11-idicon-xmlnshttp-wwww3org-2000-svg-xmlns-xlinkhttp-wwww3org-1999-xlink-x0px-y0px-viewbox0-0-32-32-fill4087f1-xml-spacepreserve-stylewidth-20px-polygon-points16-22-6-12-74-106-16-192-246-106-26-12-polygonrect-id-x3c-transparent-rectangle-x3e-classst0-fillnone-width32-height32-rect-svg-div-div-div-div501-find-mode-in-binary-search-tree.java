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
    public int[] findMode(TreeNode root) {
        Map<Integer, ArrayList<Integer>> valueMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        int maxCount = 1; 
        while(!st.isEmpty()) {
            TreeNode last = st.pop();
            if(last.right!=null) {
                st.push(last.right);
            }
            if(last.left!=null) {
                st.push(last.left);
            }
            int val = last.val;
            if(countMap.get(val)==null) {
                countMap.put(val, 1);
                valueMap.computeIfAbsent(1, v->new ArrayList<Integer>()).add(val);
            } else {
                countMap.put(val, countMap.get(val)+1);
                valueMap.computeIfAbsent(
                    countMap.get(val), v->new ArrayList<Integer>()).add(val);
                maxCount = Math.max(maxCount, countMap.get(val));
            }
        }
       ArrayList<Integer> ans = valueMap.get(maxCount);
        int size = ans.size();
        int ansArray[] = new int[size];
        for(int i=0; i<size; i++) {
            ansArray[i] = ans.get(i);
        }
        return ansArray;
        
    }
    
}