class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
		List<String> resultList = new ArrayList<String>();
        //int [][]word1Array = new int[words1.length][];
        //int [][]word2Array = new int[words2.length][];
       
        int [] tempMax = new int[26];
        for(int i=0; i<words2.length;i++) {
           int [] res = countArray(words2[i]);
           for(int k =0; k<26;k++) {
                if(tempMax[k]<res[k]) {
                	tempMax[k] = res[k];
                }
           }
        }
        for(int i=0; i<words1.length;i++) {
           int [] res = countArray(words1[i]);
            for(int j=0;j<26;j++) {
                if(res[j]>=tempMax[j]) {
                    if(j==25) {
                        resultList.add(words1[i]);
                    }
                    continue;
                }
                else {
                    break;
                }
            }
        
        }
        
        return resultList;
        
    
    }
    
    int[] countArray(String s) {
        int charA[] = new int[26];
        for(char c : s.toCharArray()) {
            charA[c-'a'] += 1; 
        }
        return charA;
    }
}