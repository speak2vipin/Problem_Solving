class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int score = 0;
		int maxScore = 0;
		int j=0;
		Set<Integer> intSet = new HashSet<Integer>();
		int i = 0;
		while(i<nums.length) {
			if (intSet.add(nums[i])) {
				score += nums[i];
				i++;
			} else {
				maxScore = score > maxScore ? score : maxScore;
				intSet.remove(nums[j]);
				score-=nums[j];
				j++;
			}	
		}
		maxScore = score > maxScore ? score : maxScore;
		return maxScore;
    }
}