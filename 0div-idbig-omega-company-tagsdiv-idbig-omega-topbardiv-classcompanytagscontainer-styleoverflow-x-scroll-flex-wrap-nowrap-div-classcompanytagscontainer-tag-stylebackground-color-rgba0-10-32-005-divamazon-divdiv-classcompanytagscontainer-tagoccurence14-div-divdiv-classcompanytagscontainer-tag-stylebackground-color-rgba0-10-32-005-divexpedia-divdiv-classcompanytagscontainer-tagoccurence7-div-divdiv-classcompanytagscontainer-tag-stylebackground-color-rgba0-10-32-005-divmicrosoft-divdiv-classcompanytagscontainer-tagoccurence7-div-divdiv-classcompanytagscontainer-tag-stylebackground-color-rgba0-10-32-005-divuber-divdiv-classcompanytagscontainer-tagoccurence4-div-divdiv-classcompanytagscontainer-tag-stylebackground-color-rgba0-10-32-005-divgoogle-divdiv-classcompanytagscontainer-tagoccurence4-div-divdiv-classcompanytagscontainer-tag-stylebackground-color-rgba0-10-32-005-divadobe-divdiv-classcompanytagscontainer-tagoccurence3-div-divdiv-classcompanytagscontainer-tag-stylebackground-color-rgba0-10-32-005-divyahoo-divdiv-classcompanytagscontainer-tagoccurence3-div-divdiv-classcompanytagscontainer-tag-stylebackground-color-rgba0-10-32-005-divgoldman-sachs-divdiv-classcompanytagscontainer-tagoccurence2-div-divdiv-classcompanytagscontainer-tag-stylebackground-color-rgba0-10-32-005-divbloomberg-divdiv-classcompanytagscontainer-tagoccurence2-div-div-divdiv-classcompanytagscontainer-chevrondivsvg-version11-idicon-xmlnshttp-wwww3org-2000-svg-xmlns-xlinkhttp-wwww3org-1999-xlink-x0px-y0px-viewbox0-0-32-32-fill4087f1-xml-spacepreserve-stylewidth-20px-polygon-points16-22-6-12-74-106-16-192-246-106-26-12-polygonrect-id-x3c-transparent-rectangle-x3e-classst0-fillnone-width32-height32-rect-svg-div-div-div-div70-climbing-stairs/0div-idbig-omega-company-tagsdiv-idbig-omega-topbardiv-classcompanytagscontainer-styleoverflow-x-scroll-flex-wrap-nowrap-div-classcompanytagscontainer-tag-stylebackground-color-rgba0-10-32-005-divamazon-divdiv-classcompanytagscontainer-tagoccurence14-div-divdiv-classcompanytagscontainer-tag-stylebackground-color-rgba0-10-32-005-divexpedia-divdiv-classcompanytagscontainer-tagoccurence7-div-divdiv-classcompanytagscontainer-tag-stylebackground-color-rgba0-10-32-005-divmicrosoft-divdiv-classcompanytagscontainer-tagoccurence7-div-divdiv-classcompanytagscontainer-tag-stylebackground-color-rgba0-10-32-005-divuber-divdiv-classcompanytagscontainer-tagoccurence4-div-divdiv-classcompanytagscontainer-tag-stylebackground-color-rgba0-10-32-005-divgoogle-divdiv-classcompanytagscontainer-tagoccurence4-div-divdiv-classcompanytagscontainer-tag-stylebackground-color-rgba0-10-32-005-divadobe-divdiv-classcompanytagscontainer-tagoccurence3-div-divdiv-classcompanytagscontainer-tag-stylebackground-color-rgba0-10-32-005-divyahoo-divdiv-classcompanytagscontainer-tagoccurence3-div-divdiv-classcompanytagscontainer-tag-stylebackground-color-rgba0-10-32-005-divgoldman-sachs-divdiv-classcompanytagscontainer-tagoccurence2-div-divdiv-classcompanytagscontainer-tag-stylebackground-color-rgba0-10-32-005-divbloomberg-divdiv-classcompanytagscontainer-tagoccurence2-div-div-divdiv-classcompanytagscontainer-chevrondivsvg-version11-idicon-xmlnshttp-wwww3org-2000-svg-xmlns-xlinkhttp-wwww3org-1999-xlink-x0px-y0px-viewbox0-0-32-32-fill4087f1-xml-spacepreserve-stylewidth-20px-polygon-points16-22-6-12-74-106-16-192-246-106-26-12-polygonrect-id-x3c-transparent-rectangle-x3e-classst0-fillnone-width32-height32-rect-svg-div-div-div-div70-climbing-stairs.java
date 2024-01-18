class Solution {
    public int climbStairs(int n) {
        if(n<=0) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int total = 0;
        for(int i=2; i<n+1; i++) {
            total = first + second;
            first = second;
            second = total;
        }
        return second;
      
        
        
    }
}