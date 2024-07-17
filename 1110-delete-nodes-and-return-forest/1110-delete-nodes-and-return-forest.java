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
    List<TreeNode> ans = null;
    Set<Integer> toBeDelete = null;
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        toBeDelete = new HashSet<>();
        for(int val : to_delete) {
            toBeDelete.add(val);
        }
        /*postorder(root);
        if(!toBeDelete.contains(root.val)) {
            ans.add(root);
        }*/
        
        useLevelOrderTraversal(root);
        
        return ans;
    }
    
    TreeNode postorder(TreeNode root) {
        if(root==null) {
            return null;
        }
        root.left = postorder(root.left);
        root.right = postorder(root.right);
        if(toBeDelete.contains(root.val)) {
            // Root.left would be not null iff, it is not part of toBeDelete set same apply for root.right
            if(root.left!=null) {
                ans.add(root.left);
            }
            if(root.right!=null) {
                ans.add(root.right);
            }
            return null;
        }
        return root;
    }
    
    void useLevelOrderTraversal(TreeNode root) {
        Queue<TreeNode> qe = new LinkedList<>();
        qe.offer(root);
        while(!qe.isEmpty()) {
            TreeNode top = qe.poll();
            if(top.left!=null) {
                qe.offer(top.left);
                if(toBeDelete.contains(top.left.val)) {
                    top.left = null;
                }
            }
            if(top.right!=null) {
                qe.offer(top.right);
                if(toBeDelete.contains(top.right.val)) {
                    top.right = null;
                }
            }
            if(toBeDelete.contains(top.val)) {
                if(top.left!=null) {
                    ans.add(top.left);
                }
                if(top.right!=null) {
                    ans.add(top.right);
                }
            }
        }
        if(!toBeDelete.contains(root.val)) {
            ans.add(root);
        }
    }
    
    
}