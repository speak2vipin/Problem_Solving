class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long city[] = new long[n];
        for(int road[] : roads) {
            city[road[0]]++;
            city[road[1]]++;
        }
        Arrays.sort(city);
        long totalImportance = 0l;
        for(int i=n; i>0; i--) {
            totalImportance += city[i-1] * i;
        }
        return totalImportance;
    }
}