class Solution {
    public boolean isItPossible(String word1, String word2) {
        int [] w1 = new int[26];
        int [] w2 = new int[26];
        int L1 = word1.length(); 
        int L2 = word2.length();
     
        for(int i=0; i<L1; i++) {
            int index = word1.charAt(i)-'a';
            w1[index] = w1[index] + 1;
        }
        for(int i=0; i<L2; i++) {
            int index = word2.charAt(i)-'a';
            w2[index] = w2[index] + 1;   
        }
        
        for(int i=0; i<26; i++) {
            if(w1[i]>0) {
                 for(int j=0; j<26; j++) {
                      if(w2[j]>0) {
                          w1[j]++;
                          w1[i]--;
                          w2[i]++;
                          w2[j]--;
                          int x = count(w1);
                          int y = count(w2);
                          if(x==y) {
                              return true;
                          }
                          w1[j]--;
                          w1[i]++;
                          w2[i]--;
                          w2[j]++;
                      }
                 }
            }
        }    
        return false;
            
    } 
        
        int count (int [] letter) {
            int count = 0;
            for(int i=0; i<26; i++) {
                if(letter[i]>0) {
                    count++;
                }
            }
            return count;
        }
    
    
    
}