class Solution {
    public int minimizeArrayValue(int[] nums) {
        
		/*PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int x[], int y[]) {
				return (y[0]-x[0]==0) ? x[1] - y[1] : y[0] - x[0];
			}
		});
		int N = nums.length;
		for (int i = 1; i < N; i++) {
			pq.offer(new int[] { nums[i], i });
		}
		int ans = Integer.MIN_VALUE;
		while (!pq.isEmpty()) {
			int top[] = pq.poll();
			int index = top[1];
			//System.out.println(top[0] + " " + top[1]);

			if (nums[index] == top[0] && nums[index - 1] < nums[index]) {
				nums[index] = nums[index] - 1;
				nums[index - 1] = nums[index - 1] + 1;
				pq.offer(new int[] { nums[index], index });
				if(index-1!=0)
					pq.offer(new int[] { nums[index - 1], index-1 });
			}
		}
		for (int num : nums) {
			ans = Math.max(ans, num);
		}
		return ans;
        */
            double answer = 0, prefixSum = 0;   
	        // 3,7,1,6

	        // Iterate over nums, update prefix sum and answer.
	        for (int i = 0; i < nums.length; ++i) {
	            prefixSum += nums[i];
                // This problem is like trapping rain water i.e. Finding average of water vessels to store it
                // flow would go from right to left so it would average of prefix sum
                // Take care of Math.ceil as it return double so make prefixSum as double
                // or else it will return u an int. (int/int) will be int and 
                // then Math.ceil won't be useful
	            answer = Math.max(answer, Math.ceil(prefixSum/(i + 1)));
                // Another trick of finding ceil is
                //long answer = 0, prefixSum = 0;
                //prefixSum += nums[i];
                //answer = MAth.max(answer, Math.ceil((prefixSum + i)/(i+1)));
                // Prefix/(i+1) + i/ (i+1) would be ceil number.
                    
                
	        }

	        return (int)answer;
	
    }
}