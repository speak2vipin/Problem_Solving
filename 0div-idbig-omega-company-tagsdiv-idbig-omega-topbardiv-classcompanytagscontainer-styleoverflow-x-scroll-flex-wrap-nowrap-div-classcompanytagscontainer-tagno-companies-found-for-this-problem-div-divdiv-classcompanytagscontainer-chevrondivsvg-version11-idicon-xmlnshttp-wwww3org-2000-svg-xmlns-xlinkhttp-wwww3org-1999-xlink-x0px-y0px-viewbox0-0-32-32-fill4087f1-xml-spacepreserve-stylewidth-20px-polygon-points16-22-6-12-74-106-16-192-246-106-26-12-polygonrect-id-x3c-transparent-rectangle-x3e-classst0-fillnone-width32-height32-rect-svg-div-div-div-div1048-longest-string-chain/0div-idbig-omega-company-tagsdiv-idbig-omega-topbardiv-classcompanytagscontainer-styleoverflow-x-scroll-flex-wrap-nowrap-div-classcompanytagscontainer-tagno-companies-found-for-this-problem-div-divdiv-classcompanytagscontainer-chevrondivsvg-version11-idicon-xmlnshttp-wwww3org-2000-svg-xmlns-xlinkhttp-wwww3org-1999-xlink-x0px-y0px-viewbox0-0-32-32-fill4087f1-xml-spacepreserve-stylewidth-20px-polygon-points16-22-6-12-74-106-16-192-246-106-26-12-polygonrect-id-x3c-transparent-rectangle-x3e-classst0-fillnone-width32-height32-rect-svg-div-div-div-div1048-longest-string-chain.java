class Solution {
    // Total TC : O(NlogN + N*l*l)
    // Total SC : O(N) or in worst case values would be N*L i.e. New Intger object for every next i.e. substring at line number 19 
    public int longestStrChain(String[] words) {
        // TC : O(NlogN)
        Arrays.sort(words, (l1, l2)-> l1.length()-l2.length());
        int res = 0;
        Map<String, Integer> memo = new HashMap<>();
        // TC: N * l * l 
        for(String word : words) {
            // At least one word must be inserted anywhere in word A to make it word B
            // that's why we are not doing 
            // memo.put(word, memo.getOrDefault(word, 0)+1);
            memo.put(word, 1); 
            // TC: length of word --> l*l
            for(int i=0; i<word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                // TC: length of word --> l
                String next = sb.deleteCharAt(i).toString();
                if(memo.keySet().contains(next)) {
                    memo.put(word, Math.max(memo.get(word), memo.get(next)+1)); 
                }
            }
            res = Math.max(res, memo.get(word));
        }
        return res;
    }
}