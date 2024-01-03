class Solution {
    public int numberOfBeams(String[] bank) {
        int count = 0;
        int m = bank.length;
        int n = bank[0].length();
        int prevlaser = 0;
        for(int i=0; i<m; i++) {
            int currlaser = 0;
            for(int j=0; j<n; j++) {
                if(bank[i].charAt(j)=='1') {
                    currlaser++;
                }
            }
            if(currlaser!=0) {
                count = count + currlaser*prevlaser;
                prevlaser = currlaser;
            }
        }
        return count;
        
    }
}