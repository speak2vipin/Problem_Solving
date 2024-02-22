class Solution {
    public int findJudge(int n, int[][] trust) {
        int count[] = new int[n+1];
        boolean outgoing[] = new boolean[n+1];
        for(int t[] : trust) {
            count[t[1]]++;
            outgoing[t[0]] = true;
        }
        for(int i=1; i<=n; i++) {
            if(count[i]==n-1 && !outgoing[i]) {
                return i;
            } 
        }
        return -1;
    }
}