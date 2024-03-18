class Solution {
    public int minimumDeletions(String word, int k) {
        
        int freq[] = new int[26];
        int n = word.length();
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            freq[word.charAt(i)-'a']++;
        }
        
        int ans = Integer.MAX_VALUE;
        
        // Here every freq will reduced to make |freq(word[i]) - freq(word[j])| <= k true
        // Simply consider every freq as smallest
        // If x>y then all y needs to be deleted
        // Or if y-k<=k, no changes required
        // else reduced the minimum character
        for(int x : freq) {
            int count = 0;
            for(int y : freq) {
                count += x>y?y:(y-x<=k?0:(y-x-k));
            }
            ans = Math.min(ans, count);
        }
        
        return ans;
    }
}