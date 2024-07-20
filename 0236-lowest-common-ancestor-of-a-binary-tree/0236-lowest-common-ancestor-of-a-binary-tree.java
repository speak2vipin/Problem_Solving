/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        StringBuilder pPath = new StringBuilder();
        StringBuilder qPath = new StringBuilder();
        
        traverse(root, p, pPath);
        traverse(root, q, qPath);
        
        System.out.println(pPath);
        System.out.println(qPath);
        
        int commonPath = 0;
        while(commonPath<pPath.length() 
             && commonPath<qPath.length()
             && pPath.charAt(commonPath)==qPath.charAt(commonPath)) {
            commonPath++;
        }
        TreeNode res = root;
        for(int i=0; i<commonPath; i++) {
            if(pPath.charAt(i)=='L') {
                res = res.left;
            } else {
                res = res.right;
            }
        }
        return res;
    }
    
    boolean traverse(TreeNode root, TreeNode node, StringBuilder sb) {
        if(root==null) {
            return false;
        }
        if(root==node) {
            return true;
        }
        sb.append("L");
        if(traverse(root.left, node, sb)) {
            return true;
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("R");
        if(traverse(root.right, node, sb)) {
            return true;
        }
        sb.deleteCharAt(sb.length()-1);
        return false;
    }
}