class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
   
        int score = 0;
        int i = 0;
        int j = tokens.length-1;
        
        while(i<=j) {
            if(power<tokens[i]) {
                if(i==j || score==0) {
                    break;
                }
                score--;
                power += tokens[j];
                j--;
            } else {
                power -= tokens[i];
                score++;
                i++;
            }
        }
        return score;
        
    }
}