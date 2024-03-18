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
        //Arrays.sort(freq);
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