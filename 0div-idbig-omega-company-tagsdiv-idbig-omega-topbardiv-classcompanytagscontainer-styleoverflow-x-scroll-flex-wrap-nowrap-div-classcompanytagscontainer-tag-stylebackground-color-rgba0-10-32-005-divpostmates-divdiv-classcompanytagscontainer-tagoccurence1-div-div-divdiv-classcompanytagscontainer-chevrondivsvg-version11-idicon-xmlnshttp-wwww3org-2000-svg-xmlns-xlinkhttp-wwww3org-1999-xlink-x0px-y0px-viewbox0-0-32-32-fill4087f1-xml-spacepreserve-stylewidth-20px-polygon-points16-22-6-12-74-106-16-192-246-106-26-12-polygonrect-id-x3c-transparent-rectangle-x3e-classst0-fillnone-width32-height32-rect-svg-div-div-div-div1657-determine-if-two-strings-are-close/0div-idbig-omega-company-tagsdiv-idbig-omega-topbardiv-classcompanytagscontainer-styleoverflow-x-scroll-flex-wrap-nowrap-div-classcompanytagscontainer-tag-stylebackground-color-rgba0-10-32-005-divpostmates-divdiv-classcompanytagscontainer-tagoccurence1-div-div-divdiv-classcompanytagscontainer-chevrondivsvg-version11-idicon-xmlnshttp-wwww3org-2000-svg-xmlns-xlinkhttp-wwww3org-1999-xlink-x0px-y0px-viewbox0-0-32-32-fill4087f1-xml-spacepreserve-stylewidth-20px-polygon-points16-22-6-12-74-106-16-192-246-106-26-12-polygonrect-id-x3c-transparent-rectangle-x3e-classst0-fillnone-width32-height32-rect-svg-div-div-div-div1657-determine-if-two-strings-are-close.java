class Solution {
    public boolean closeStrings(String word1, String word2) {
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