class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean visited[] = new boolean[n];
        Queue<Integer> qe = new LinkedList<Integer>();
        qe.add(source);
        while(!qe.isEmpty()) {
            int num = qe.poll();
            if(num==destination) {
                return true;
            }
            Set<Integer>neighboursSet = neighbours(edges, num);
            for(int index : neighboursSet) {
                if(!visited[index]) {
                    visited[index] = true;
                    qe.add(index);
                }
            } 
        }
        return false;
    }
    
    Set<Integer> neighbours(int[][]edges, int node) {
        int len = edges.length;
        Set<Integer> neighboursNodes = new HashSet<Integer>();
        for(int[]edge : edges) {
            if(edge[0]==node) {
                neighboursNodes.add(edge[1]);
            } else if(edge[1]==node) {
                neighboursNodes.add(edge[0]);
            }
        }
        return neighboursNodes;
    }
    
    
}