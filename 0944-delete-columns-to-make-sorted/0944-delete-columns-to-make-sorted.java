class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        int L = strs.length;
        int wordLength = strs[0].length();
        for(int i=0; i<wordLength; i++) {
            char temp = strs[0].charAt(i);
            for(int j=1; j<L; j++) {
                char innerTemp = strs[j].charAt(i);
                if(temp<=innerTemp) {
                    temp = innerTemp;
                } else {
                    count++;
                    break;
                }
            }  
        }
        return count; 
    }
}