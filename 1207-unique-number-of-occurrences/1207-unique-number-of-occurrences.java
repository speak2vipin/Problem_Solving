class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> arrMap = new HashMap<Integer, Integer>();
        for(int temp : arr) {
            arrMap.put(temp, arrMap.getOrDefault(temp, 0)+1);
        }
        HashSet<Integer> arrSet = new HashSet<Integer>(arrMap.values());
        if(arrMap.size()==arrSet.size()) {
        	return true;
        }
        return false;   
    }
}