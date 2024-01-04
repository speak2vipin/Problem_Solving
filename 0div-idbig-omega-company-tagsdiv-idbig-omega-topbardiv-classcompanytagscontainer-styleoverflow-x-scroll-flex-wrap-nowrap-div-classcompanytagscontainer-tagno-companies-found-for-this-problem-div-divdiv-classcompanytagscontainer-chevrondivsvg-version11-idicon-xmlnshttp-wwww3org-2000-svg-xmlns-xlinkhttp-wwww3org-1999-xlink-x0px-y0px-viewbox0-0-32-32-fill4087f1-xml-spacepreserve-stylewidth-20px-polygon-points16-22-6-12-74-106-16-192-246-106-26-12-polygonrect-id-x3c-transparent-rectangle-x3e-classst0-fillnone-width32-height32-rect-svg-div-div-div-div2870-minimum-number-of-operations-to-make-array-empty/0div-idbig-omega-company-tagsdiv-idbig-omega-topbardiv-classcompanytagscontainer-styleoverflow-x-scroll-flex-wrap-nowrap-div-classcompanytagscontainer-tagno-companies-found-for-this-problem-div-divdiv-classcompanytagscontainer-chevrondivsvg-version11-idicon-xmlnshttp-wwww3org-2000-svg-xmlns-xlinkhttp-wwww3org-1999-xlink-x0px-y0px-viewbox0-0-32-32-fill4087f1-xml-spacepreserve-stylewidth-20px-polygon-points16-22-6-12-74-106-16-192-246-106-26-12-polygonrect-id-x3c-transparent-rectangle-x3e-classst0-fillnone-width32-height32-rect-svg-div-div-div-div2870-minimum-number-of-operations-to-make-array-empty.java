class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
		for (int num : nums) {
			numMap.put(num, numMap.getOrDefault(num, 0) + 1);
		}
		int count = 0;
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (Integer key : numMap.values()) {
			// freqMap.put(numMap.get(key), freqMap.getOrDefault(numMap.get(key), 0) + 1);
			if (key == 1) {
				return -1;
			} else if ((key % 3) == 0) {
				count += key / 3;
			} else if ((key % 3) % 2 == 0) {
				count += key / 3;
				count += 1;
			} else if ((key % 3) % 2 != 0) {
				count += key / 3;
				count += 1;
			}
		}
		
		return count;
 
    }
}