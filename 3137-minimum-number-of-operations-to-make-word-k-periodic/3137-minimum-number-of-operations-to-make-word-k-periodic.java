class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> map = new HashMap<>();
        int interval = word.length()/k;
        String temp = null;
        for(int i=0; i<interval; i++) {
            temp = word.substring(i*k, (i+1)*k);
            map.put(temp, map.getOrDefault(temp, 0)+1);
        }
        int max = 0;
        for(int val : map.values()) {
            max = Math.max(max, val);
        }
        return interval - max;
        
    }
}