class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int x : arr) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for(Integer val : freqMap.values()) {
            if(!set.add(val)) {
                return false;
            }
        }
        return true;
    }
}