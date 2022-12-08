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
    List<Integer> l1 = new ArrayList<Integer>();
    List<Integer> l2 = new ArrayList<Integer>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null) {
            return false;
        }
        leafSequence(root1, l1);
        leafSequence(root2, l2);
        if(l1.size()!=l2.size()) {
            return false;
        }
        int N = l1.size();
        for(int i=0; i<N; i++) {
            if(l1.get(i)!=l2.get(i))  {
                return false;
            }
        }
        return true;
    }
    
    void leafSequence (TreeNode t1, List<Integer> temp) {
        if(t1==null) {
            return;
        }
        if(t1.left==null && t1.right==null) {
            temp.add(t1.val);
            return;
        }
        
        leafSequence(t1.left, temp);
        leafSequence(t1.right, temp);
    }
}