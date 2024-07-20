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

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start = new StringBuilder();
        StringBuilder dest = new StringBuilder();
        
        traverse(root, startValue, start);
        traverse(root, destValue, dest);
        System.out.println(start);
        System.out.println(dest);
        
        int i = 0, j = 0, commmonPath = 0;
        while(commmonPath<start.length() 
              && commmonPath<dest.length() 
              && start.charAt(commmonPath)==dest.charAt(commmonPath)) {
            commmonPath++;
        }
        
        String response = "";
        for(i=commmonPath ; i<start.length(); i++) {
            response += "U"; 
        }
        
        for(j=commmonPath; j<dest.length(); j++) {
            response += dest.charAt(j);
        }
        return response;
    }
    
    boolean traverse(TreeNode root, int nodeValue, StringBuilder sb) {
        if(root==null) {
            return false;
        }
        if(root.val==nodeValue) {
            return true;
        }
        sb.append('L');
        if(traverse(root.left, nodeValue, sb)) {
            return true;
        }
        if(sb.length()>0) {
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append('R');
        if(traverse(root.right, nodeValue, sb)) {
            return true;        
        }
        if(sb.length()>0) {
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }
}