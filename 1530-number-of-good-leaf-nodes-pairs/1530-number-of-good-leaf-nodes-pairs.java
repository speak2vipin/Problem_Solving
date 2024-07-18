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
    int ans = 0;
    public int countPairs(TreeNode root, int distance) {
        helper(root, distance);
        return ans;
    }
    
   List<Integer> helper(TreeNode root, int d) {
       List<Integer> l = new ArrayList();
        if(root==null) {
            return l;
        }
        if(root.left==null && root.right==null) {
            l.add(1);
            return l;
        }
       List<Integer> left = helper(root.left, d);
       List<Integer> right = helper(root.right, d);
       for(int x : left) {
           for(int y : right) {
               if(x+y<=d) {
                   ans++;
               }
           }
       }
       
       for(int x : left) {
           if(x+1<=d) {
               l.add(x+1);
           }
       }
       for(int y : right) {
           if(y+1<=d) {
               l.add(y+1);
           }
       }
       return l;
    }
}