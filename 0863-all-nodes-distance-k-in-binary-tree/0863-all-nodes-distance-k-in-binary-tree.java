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
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       Map<Integer, List<Integer>> graph = new HashMap<>();
        dfsBuild(root, null, graph);
        
        List<Integer> answer = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<int[]>queue = new LinkedList<>();
        
        queue.add(new int[]{target.val, 0});
        visited.add(target.val);
        while(!queue.isEmpty()) {
            int cur[] = queue.poll();
            List<Integer> neighbors = graph.get(cur[0]);
            int distance = cur[1];
            if(distance==k) {
                answer.add(cur[0]);
                continue;
            }
            if(neighbors!=null) {
                for(Integer neighbor : neighbors) {
                    if(!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(new int[]{neighbor, distance+1});
                    }
                }
            }
        }
        return answer;
    }
    
    private void dfsBuild(TreeNode cur, TreeNode parent, Map<Integer, List<Integer>> graph) {
        if(cur!=null && parent!=null) {
            int curVal = cur.val;
            int parVal = parent.val;
            graph.putIfAbsent(curVal, new ArrayList<>());
            graph.putIfAbsent(parVal, new ArrayList<>());
            graph.get(curVal).add(parVal);
            graph.get(parVal).add(curVal);
        }
        if(cur!=null && cur.left!=null) {
            dfsBuild(cur.left, cur, graph);
        }
        if(cur!=null && cur.right!=null) {
            dfsBuild(cur.right, cur, graph);
        }
    }
}