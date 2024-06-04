class Solution {
    int count = 0;
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        helper(s, wordSet, 0, new StringBuilder(), result);
        System.out.println(count);
        return result;
    }
    
    void helper(String s, Set<String> wordSet, int index, StringBuilder sentence, List<String> result) {
        if(index==s.length()) {
            count++;
            result.add(sentence.toString().trim());
            return;
        }
        for(int i=index+1; i<=s.length(); i++) {
            String word = s.substring(index, i);
            if(wordSet.contains(word)) {
                int len = sentence.length();
                sentence.append(word).append(" ");
                helper(s, wordSet, i, sentence, result);
                sentence.setLength(len);
            }
        }
        
    }
}