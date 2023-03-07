class Solution {
    public int maximumCandies(int[] candies, long k) {        
       // long high = 10000000;
        long low = 1;
        long high = 10000000;
        for(int candy : candies) {
            high+=candy;
        }
        if(high<k) {
            return 0;
        }

        long mid = 0;
        long ans = 0;
        
        while(low<=high) {
            mid = low + (high-low)/2;
            if(isPossible(candies, k, mid)) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return (int)ans;
    }
    
    boolean isPossible(int candies[], long k, long temp) {
        long count = 0;
        for(int candy : candies) {
            count += (long)candy/temp;
        }
        return count>=k;
    }
}