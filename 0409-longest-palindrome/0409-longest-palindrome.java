class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char temp = s.charAt(i);
            map.put(temp, map.getOrDefault(temp, 0)+1);
        }
        int count = 0;
        int odd = 0;
        for(Integer val : map.values()) {
            if(val%2==0) {
                count += val;
            } else {
                if(val<odd) {
                    count += val-1;
                } else {
                    if(odd!=0)
                        count += odd-1;
                    odd = val;
                }
                
            }
        }
        return count + odd;
    }
}