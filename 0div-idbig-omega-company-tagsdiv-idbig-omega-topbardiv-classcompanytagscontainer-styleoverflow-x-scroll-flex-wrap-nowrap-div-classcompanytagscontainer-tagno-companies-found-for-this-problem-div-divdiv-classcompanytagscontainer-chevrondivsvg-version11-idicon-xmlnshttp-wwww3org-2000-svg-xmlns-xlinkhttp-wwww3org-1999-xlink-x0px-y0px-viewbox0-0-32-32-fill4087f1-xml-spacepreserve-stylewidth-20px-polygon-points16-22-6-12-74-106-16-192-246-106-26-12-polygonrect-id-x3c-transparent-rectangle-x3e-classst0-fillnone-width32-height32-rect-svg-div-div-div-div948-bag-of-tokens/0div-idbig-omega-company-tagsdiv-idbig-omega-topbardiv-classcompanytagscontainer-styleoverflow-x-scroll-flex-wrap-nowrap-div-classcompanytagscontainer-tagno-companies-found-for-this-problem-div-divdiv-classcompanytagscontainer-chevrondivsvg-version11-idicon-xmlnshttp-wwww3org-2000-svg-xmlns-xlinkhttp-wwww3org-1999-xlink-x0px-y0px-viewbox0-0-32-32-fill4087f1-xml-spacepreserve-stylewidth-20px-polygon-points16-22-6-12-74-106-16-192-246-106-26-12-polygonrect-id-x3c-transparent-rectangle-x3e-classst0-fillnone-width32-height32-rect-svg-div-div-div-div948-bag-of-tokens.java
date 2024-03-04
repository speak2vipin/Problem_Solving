class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int index = 0;
        int count = 0;
        int i = 0;
        int j = tokens.length-1;
        int total = 0;
        //while(i<tokens.length) {
          //  total += tokens[i++];
        //}
        //if(total<=power) {
          //  return tokens.length;
        //}
         //i = 0;
        while(i<=j) {
            if(power<tokens[i]) {
                if(i==j || count==0) {
                    break;
                }
                count--;
                power += tokens[j];
                j--;
            } else {
                power -= tokens[i];
                count++;
                i++;
            }
        }
        return count;
        
    }
}