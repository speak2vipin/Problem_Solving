class Solution {
    int ans = 0;
    public int maxVowels(String s, int k) {
        int N = s.length();
        int count = 0;
     
        for(int i=0; i<N; i++) {
            if(i<k) {
                if(isVowel(s.charAt(i))) {
                    count++;
                }
            } else {
                if(isVowel(s.charAt(i-k))) {
                    count--;
                }
                if(isVowel(s.charAt(i))) {
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
    
    boolean isVowel(char character) {
        return 
            character=='a' || character=='i' || character== 'o' || 
            character=='u' || character=='e';
    }
}