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
    public int amountOfTime(TreeNode root, int start) {
        int count = 0;
        Map<Integer, Set<Integer>> relation = new HashMap<>();
        traverse(root, relation, 0);
        Queue<Integer> qe = new LinkedList<>();
        qe.offer(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
       
        while(!qe.isEmpty()) {
            int size = qe.size();
            for(int i=0; i<size; i++) {
               Set<Integer> neighbors = relation.get(qe.poll());
                for(Integer neighbor : neighbors) {
                    if(!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        qe.offer(neighbor);
                    }
                }
            }
            count++;
        }
        return count-1;
    }
    
    void traverse(TreeNode curr, Map<Integer, Set<Integer>> relation, int parent) {
        if(curr==null){
            return;
        }
        if(relation.get(curr.val)==null) {
            relation.put(curr.val, new HashSet<>());
        }
        Set<Integer> neighbors = relation.get(curr.val);
        if(parent!=0) {
            neighbors.add(parent);
        }
        if(curr.left!=null) {
            neighbors.add(curr.left.val);
        }
         if(curr.right!=null) {
            neighbors.add(curr.right.val);
        }
        traverse(curr.left, relation, curr.val);
        traverse(curr.right, relation, curr.val);
    }
}