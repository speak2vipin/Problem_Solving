class Solution {
   public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					List<Integer> l = new ArrayList<>();
					l.add(nums[i]);
					l.add(nums[j]);
					l.add(nums[k]);
					res.add(l);
					while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
						j++;
					}
					j++;
				} else if (sum > 0) {
					k--;
				} else {
					j++;
				}
			}
			while (i + 1 < nums.length  && nums[i] == nums[i + 1]) {
				i++;
			}
		}
		return res;
	}
}