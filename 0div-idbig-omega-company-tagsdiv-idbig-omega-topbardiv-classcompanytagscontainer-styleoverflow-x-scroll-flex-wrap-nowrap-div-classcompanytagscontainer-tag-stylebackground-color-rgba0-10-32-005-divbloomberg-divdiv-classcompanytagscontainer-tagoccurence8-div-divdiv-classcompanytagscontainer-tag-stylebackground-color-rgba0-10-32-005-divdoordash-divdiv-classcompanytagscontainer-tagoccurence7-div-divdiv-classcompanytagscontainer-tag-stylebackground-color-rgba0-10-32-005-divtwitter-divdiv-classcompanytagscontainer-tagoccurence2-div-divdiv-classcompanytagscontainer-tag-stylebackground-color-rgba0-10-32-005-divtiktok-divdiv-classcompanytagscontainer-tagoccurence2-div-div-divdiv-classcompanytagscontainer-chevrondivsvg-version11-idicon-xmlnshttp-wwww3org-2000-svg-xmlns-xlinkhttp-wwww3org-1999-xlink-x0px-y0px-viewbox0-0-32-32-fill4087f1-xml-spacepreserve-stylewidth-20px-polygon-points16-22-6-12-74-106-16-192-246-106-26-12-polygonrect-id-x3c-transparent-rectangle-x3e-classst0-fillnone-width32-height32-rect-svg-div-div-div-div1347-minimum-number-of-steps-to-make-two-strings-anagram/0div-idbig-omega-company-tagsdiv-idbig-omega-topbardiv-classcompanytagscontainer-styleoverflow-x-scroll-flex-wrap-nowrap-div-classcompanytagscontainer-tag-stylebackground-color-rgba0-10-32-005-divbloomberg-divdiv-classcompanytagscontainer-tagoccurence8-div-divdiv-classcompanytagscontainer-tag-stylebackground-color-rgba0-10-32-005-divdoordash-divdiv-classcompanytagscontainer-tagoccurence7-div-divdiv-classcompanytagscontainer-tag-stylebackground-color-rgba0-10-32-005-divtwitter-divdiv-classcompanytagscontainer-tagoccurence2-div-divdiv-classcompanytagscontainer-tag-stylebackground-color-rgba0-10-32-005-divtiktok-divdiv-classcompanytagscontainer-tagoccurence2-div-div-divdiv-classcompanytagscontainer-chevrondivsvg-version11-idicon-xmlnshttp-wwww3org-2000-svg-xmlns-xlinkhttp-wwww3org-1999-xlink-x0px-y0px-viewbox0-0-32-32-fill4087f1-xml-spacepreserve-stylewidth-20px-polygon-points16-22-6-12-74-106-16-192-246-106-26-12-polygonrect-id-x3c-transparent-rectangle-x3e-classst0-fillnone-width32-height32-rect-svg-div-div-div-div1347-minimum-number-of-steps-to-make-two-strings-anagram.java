class Solution {
    public int minSteps(String s, String t) {
        int count1[] = new int[26];
        int count2[] = new int[26];
        
        int n = s.length();
        
        for(int i=0; i<n; i++) {
            count1[s.charAt(i)-'a']++;
            count1[t.charAt(i)-'a']--;
        }
        int ans = 0;
        
        
        for(int i=0; i<26; i++) {
            if(count1[i]>0) {
                ans += count1[i];
            }
        }
        
        return ans;  
    }
}