class Solution {
    // Total TC : O(NlogN + N*l*l)
    public int longestStrChain(String[] words) {
        // TC : O(NlogN)
        Arrays.sort(words, (l1, l2)-> l1.length()-l2.length());
        int res = 0;
        Map<String, Integer> memo = new HashMap<>();
        // TC: N * l * l 
        for(String word : words) {
            memo.put(word, 1); 
            // TC: length of word --> l*l
            for(int i=0; i<word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                // TC: length of word --> l
                String next = sb.deleteCharAt(i).toString();
                if(memo.keySet().contains(next)) {
                    memo.put(word, Math.max(memo.get(word), memo.get(next)+1)); 
                }
                res = Math.max(res, memo.get(word));
            }
            
        }
        return res;
    }
}