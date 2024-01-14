class Solution {
    // First of all length should be same or else u can't convert
    // First condition says- char type should be same in both the Strings
    // 2nd condition says- Frequency count must be same both Strings
    // i.e. a-2 and b-1 --> a-1 and b-2 then a->1 and b->2 by operation in 1st String.
    
    public boolean closeStrings(String word1, String word2) {
        int N1 = word1.length();
        int N2 = word2.length();
        
        if(N1!=N2) {
            return false;
        }
        
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        
        for(int i=0; i<N1; i++) {
            freq1[word1.charAt(i)-'a']++;
            freq2[word2.charAt(i)-'a']++;
        }
        for(int i=0; i<26; i++) {
            if((freq1[i]==0 && freq2[i]!=0) || (freq1[i]==0 && freq2[i]!=0)) {
                return false;
            }
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        
        return Arrays.equals(freq1, freq2);
    }
    
    public boolean closeStringsUsingHashMaps(String word1, String word2) {
        int N1 = word1.length();
        int N2 = word2.length();
        
        if(N1!=N2) {
            return false;
        }
        
        HashMap<Character, Integer> freqMap1 = new HashMap<>();
        HashMap<Character, Integer> freqMap2 = new HashMap<>();
        
        for(int i=0; i<N1; i++) {
            freqMap1.put(word1.charAt(i), 
                         freqMap1.getOrDefault(word1.charAt(i), 0)+1);
        }
        
        for(int i=0; i<N2; i++) {
            freqMap2.put(word2.charAt(i), 
                         freqMap2.getOrDefault(word2.charAt(i), 0)+1);
        }
        if(!freqMap1.keySet().containsAll(freqMap2.keySet()) || !freqMap2.keySet().containsAll(freqMap1.keySet())) {
            return false;
        }
        int val[] = new int[100000];
        for(Integer v : freqMap1.values()){
            val[v]++;
        }
        
        for(Integer v : freqMap2.values()){
            if(val[v]==0) {
                return false;
            }
            val[v]--;
        }
        return true;
    }
}