class Solution {
    
    public int minCost(String colors, int[] neededTime) {
       //return Two_Pointer(colors, neededTime);
         return bottomUp(colors, neededTime);
        
    }
    
    int Two_Pointer(String colors, int []neededTime) {
        int n = colors.length();
        int start = 0;
        int end = 0;
        int totalTime = 0;
        while(start<n-1) {
            end = start+1;
            if(colors.charAt(start)==colors.charAt(end)) {
                int max = neededTime[start];
                int total = neededTime[start];
                while(end<n && colors.charAt(start)==colors.charAt(end)) {
                    total += neededTime[end];
                    max = Math.max(max, neededTime[end]);
                    end++;
                }
                totalTime += total - max;
            }
            start = end;
        }
        return totalTime;
    }
    
  int bottomUp(String c, int[]time) {
		int N = c.length();
		int dp[] = new int[N+1];
		char prevLetter = 'A';
		int prevTime = 0;
		
		for(int i=1; i<=N; i++) {
			if(c.charAt(i-1)==prevLetter) {
				dp[i] = dp[i-1] + Math.min(prevTime, time[i-1]); // U will remove least weighted ballon
				prevTime = Math.max(prevTime, time[i-1]); // U will keep the maximum weigted ballon
			} else {
				dp[i] = dp[i-1];
				prevLetter = c.charAt(i-1);
				prevTime = time[i-1];
			}
		}
      return dp[N];
	}
}