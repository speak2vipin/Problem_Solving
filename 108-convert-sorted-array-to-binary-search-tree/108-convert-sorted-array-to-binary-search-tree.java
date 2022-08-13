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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = sortedArrayToBST(nums, 0, nums.length - 1);
        return head;
        
    }
    
    public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        int mid = (start + end)/2;
        if(start<=end){
            TreeNode t = new TreeNode(nums[mid]);
            t.left = sortedArrayToBST(nums, start, mid-1);
            t.right = sortedArrayToBST(nums, mid+1, end); 
             return t;
        }else {
            return null;
        }
        
    }
    

}