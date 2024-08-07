class Solution {
    public int minimumPushes(String word) {
        Integer freq[] = new Integer[26];
        Arrays.fill(freq, 0);
        for(int i=0; i<word.length(); i++) {
            freq[word.charAt(i)-'a'] = 
                freq[word.charAt(i)-'a']==null ? 1 : freq[word.charAt(i)-'a']+1;
        }
        Arrays.sort(freq, (x,y)->Integer.compare(y, x));
        int count = 0;
        for(int i=0; i<26; i++) {
             count += (8 + i)/8 * freq[i];
        }
        return count;
     }
}