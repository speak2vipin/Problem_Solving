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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) {
            return true;
        }
        return isTrue(root.left, root.right) ;
    }
    
    boolean isTrue(TreeNode left, TreeNode right) {
        if(left==null && right==null) {
            return true;
        }
        if(left==null || right==null || left.val != right.val) {
            return false;
        }
        return isTrue(left.left, right.right) && isTrue(left.right, right.left);
    }
    
    /*boolean isTrue(TreeNode root) {
        if(root==null) {
            return true;
        }
        Queue<TreeNode>q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer>l = new ArrayList<Integer>();
            for(int i=0; i<size; i++) {
                TreeNode top = q.poll();
                if(top.val==101) {
                    l.add(101);
                } else {
                    l.add(top.val);
                    if(top.left!=null) {
                        q.offer(top.left);
                    } else {
                        q.offer(new TreeNode(101));
                    }
                    if(top.right!=null) {
                        q.offer(top.right);
                    } else {
                        q.offer(new TreeNode(101));
                    }
                }
            }
            if(!isPalindrom(l)) {
                return false;
            }
        }
        return true;
    }
    
    boolean isPalindrom(ArrayList<Integer>l) {
        int size = l.size();
        if(size<=0) {
            return true;
        }
        int st = 0;
        int en = size-1;
        while(st<en) {
            if(l.get(st)!=l.get(en)) {
                return false;
            }
            st++;
            en--;
        }
        return true;
    } */
}