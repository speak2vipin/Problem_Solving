class Solution {
    public boolean checkIfPangram(String sentence) {
        int aplhabet[] = new int[26];
        int N = sentence.length();
        for(int i=0; i<N; i++) {
            char c = sentence.charAt(i);
            aplhabet[c-'a'] += 1; 
        }
        for(int x : aplhabet) {
            if(x==0) {
                return false;
            }
        }
        return true;
    }
}