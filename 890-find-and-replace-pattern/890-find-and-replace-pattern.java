class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] patternFlatten = flattenPattern(pattern);
        List<String> responseList = new ArrayList<String>();
        for(String s : words) {
            int resultResp[] = flattenPattern(s);
            if(Arrays.equals(patternFlatten, resultResp)) {
                responseList.add(s);
            }
        }
        return responseList;
    }
    
    int[] flattenPattern(String w) {
        int [] res= new int[w.length()];
        Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        for(int i=0;i<w.length();i++) {
            charCountMap.putIfAbsent(w.charAt(i),charCountMap.size());
            res[i] = charCountMap.get(w.charAt(i));
        }
        return res;
    }
}