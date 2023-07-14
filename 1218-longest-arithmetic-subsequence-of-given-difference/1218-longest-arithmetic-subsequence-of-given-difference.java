class Solution {
    
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int answer = 1;
        for(int a : arr) {
            int before = dp.getOrDefault(a-difference, 0);
            dp.put(a, before+1);
            answer = Math.max(answer, dp.get(a));
        }
        return answer;
    }
    
    
}