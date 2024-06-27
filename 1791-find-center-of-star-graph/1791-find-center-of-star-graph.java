class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int node[] = new int[n+2];
        for(int edge[] : edges) {
            node[edge[0]]++;
            node[edge[1]]++;
        }
        for(int i=1; i<n+2; i++) {
            if(node[i]==n) {
                return i;
            }
        }
        return -1;
    }
}