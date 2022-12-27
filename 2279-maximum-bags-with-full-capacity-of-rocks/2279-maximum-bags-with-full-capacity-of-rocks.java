class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int N = rocks.length;
        int remain[] = new int[N];
        int count = 0;
        for(int i=0; i<N; i++) {
            remain[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(remain);
        
        for(int i=0; i<N; i++) {
            if(additionalRocks>=remain[i]) {
                additionalRocks = additionalRocks - remain[i];
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}