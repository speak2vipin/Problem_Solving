class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        Map<Integer, int[]> pickMap = new HashMap<>();
        for(int p[] : pick) {
            if(pickMap.get(p[0])==null)
                pickMap.put(p[0], new int[11]);
            pickMap.get(p[0])[p[1]]++;
        }
        int count = 0;
        for(Integer k : pickMap.keySet()) {
            for(int c : pickMap.get(k)) {
                if(c>k) {
                    count++;
                    break;
                }
            }
        }
    return count;
    }
}