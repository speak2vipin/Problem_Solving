class Solution {
    int dp[] = null;
    public int minCost(String colors, int[] neededTime) {
       //return Two_Pointer(colors, neededTime);
         //return bottomUp(colors, neededTime);
        int N = neededTime.length;
        dp = new int[N];
        Arrays.fill(dp, -1);
        return topDown(colors, neededTime, N-1, 0, 'A');
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
    
    int topDown(String s, int time[], int index, int prevTime, char prevLetter) {
        if(index<0) {
            return 0;
        }
        if(dp[index]!=-1) {
            return dp[index];
        }
        if(s.charAt(index)==prevLetter) {
            return dp[index] = topDown(s, time, index-1, Math.max(prevTime, time[index]) ,prevLetter) +                         Math.min(prevTime, time[index]);
            // Hold the maximum value and add minimum value to the cost
        } else {
            return dp[index] =  topDown(s, time, index-1, time[index], s.charAt(index));
        }
    }
    
    
}