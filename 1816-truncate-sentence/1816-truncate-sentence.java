class Solution {
    public String truncateSentence(String s, int k) {
        String result = null;
        String [] str = s.split(" ");
        for(int i=0;i<k;i++) {
            if(result==null) {
                result = str[i];
            } else {
                result = result + " " +str[i];
            }
        }
        return result;
    }
}