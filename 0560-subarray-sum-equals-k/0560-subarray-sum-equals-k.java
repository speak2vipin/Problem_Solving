class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        int prefixSum = 0;
        int count = 0;
        for(int num : nums) {
            prefixSum += num;
            // prefixSum-k= x;
            // prefixSum-x= k; means sum of an subarray is equal to k
            if(map.containsKey(prefixSum-k)) {
                count += map.get(prefixSum-k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}