class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        int n = num.length();
        for(int i=0; i<n-2; i++) {
            if(num.charAt(i)==num.charAt(i+1) && num.charAt(i+1)==num.charAt(i+2)) {
               if(ans.length()==0 || ans.charAt(0)<num.charAt(i)) {
                    ans = num.substring(i, i+3);
                } 
            }
        }
        return ans;
    }
}