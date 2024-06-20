class Solution {
    public int maxDistance(int[] position, int m) {
        int ans = 0;
        int n = position.length;
        Arrays.sort(position);
        int low = 0; // Minimum difference between two basket
        
        int high = (int)Math.ceil(position[n-1]/(m-1.0)); // Maximum difference between two basket
        // Why m-1.0 because 3 basket required gap of position[n-1]/2 
        while(low<=high) {
            int mid = high - (high-low)/2;
            if(canPlaceBalls(mid, position, m)) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    
    boolean canPlaceBalls(int mid, int position[], int m) {
        int prevBallPos = position[0];
        int ballsPlaced = 1;
        for(int i=1; i<position.length && ballsPlaced<m; i++) {
            int currPos = position[i];
            if((currPos - prevBallPos) >= mid) {
                ballsPlaced ++;
                prevBallPos = position[i];
            }
        }
        return ballsPlaced==m;
    
    }
}