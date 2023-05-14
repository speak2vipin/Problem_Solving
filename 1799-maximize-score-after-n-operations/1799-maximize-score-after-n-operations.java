 /*class Solution {
    PriorityQueue<int[]> pq = null;
    public int maxScore(int[] nums) {
    	
        pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int X[], int Y[]) {
                return Y[0] - X[0];
            }
        });
        
        int N = nums.length;
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                int val = gcd(nums[i], nums[j]);
                pq.offer(new int[]{val, i, j});
            }
        }
        int temp[] = new int[N];
        int multiplier = N/2;
        int ans = 0;
        while(!pq.isEmpty()) {
            int top[] = pq.poll();
            int index1 = top[1];
            int index2 = top[2];
            if(temp[index1]==0 && temp[index2]==0) {
                ans = ans + top[0] * multiplier;
                multiplier--;
                temp[index1]=1;
                temp[index2]=1;
            }
        }
        
        return ans;
    }
    
   int gcd(int A, int B) {
        if(A==0) {
            return B;
        }
        return gcd(B%A, A);
    }    
} */
    
    class Solution {
    public int backtrack(int[] nums, int mask, int pairsPicked, int[] memo) {
        // If we have picked all the numbers from 'nums' array, we can't get more score.
        if (2 * pairsPicked == nums.length) {
            return 0;
        }

        // If we already solved this sub-problem then return the stored result.
        if (memo[mask] != -1) {
            return memo[mask];
        }

        int maxScore = 0;

        // Iterate on 'nums' array to pick the first and second number of the pair.
        for (int firstIndex = 0; firstIndex < nums.length; ++firstIndex) {
            for (int secondIndex = firstIndex + 1; secondIndex < nums.length; ++secondIndex) {
    
                // If the numbers are same, or already picked, then we move to next number.
                if (((mask >> firstIndex) & 1) == 1 || ((mask >> secondIndex) & 1) == 1) {
                    continue;
                }

                // Both numbers are marked as picked in this new mask.
                int newMask = mask | (1 << firstIndex) | (1 << secondIndex);

                // Calculate score of current pair of numbers, and the remaining array.
                int currScore = (pairsPicked + 1) * gcd(nums[firstIndex], nums[secondIndex]);
                int remainingScore = backtrack(nums, newMask, pairsPicked + 1, memo);

                // Store the maximum score.
                maxScore = Math.max(maxScore, currScore + remainingScore);
                // We will use old mask in loop's next interation, 
                // means we discarded the picked number and backtracked.
            }
        }

        // Store the result of the current sub-problem.
        memo[mask] = maxScore;
        return maxScore;
    }

    public int maxScore(int[] nums) {
        int memoSize = 1 << nums.length; // 2^(nums array size)
        int[] memo = new int[memoSize];
        Arrays.fill(memo, -1);
        return backtrack(nums, 0, 0, memo);
    }

    // Utility function to calculate the gcd of two numbers.
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}