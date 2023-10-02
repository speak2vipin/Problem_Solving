class Solution {
    public boolean winnerOfGame(String colors) {
        int i = 1;
        int j = 1;
        int n = colors.length();
        if(n<3) {
            return false;
        }
        while(i<n && j<n) {
            
            while(i<n-1 && 
                  (colors.charAt(i-1)!='A' || colors.charAt(i-1)!=colors.charAt(i+1)
                    || colors.charAt(i-1)!=colors.charAt(i))) {
                i++;
            }
            if(i==n-1) {
                return false;
            }
            i++;
            while(j<n-1 && 
                  (colors.charAt(j-1)!='B' || colors.charAt(j-1)!=colors.charAt(j+1)
                    || colors.charAt(j-1)!=colors.charAt(j))) {
                j++;
            }
            if(j==n-1) {
                return true;
            }
            j++;
        }
        return true;
    }
}