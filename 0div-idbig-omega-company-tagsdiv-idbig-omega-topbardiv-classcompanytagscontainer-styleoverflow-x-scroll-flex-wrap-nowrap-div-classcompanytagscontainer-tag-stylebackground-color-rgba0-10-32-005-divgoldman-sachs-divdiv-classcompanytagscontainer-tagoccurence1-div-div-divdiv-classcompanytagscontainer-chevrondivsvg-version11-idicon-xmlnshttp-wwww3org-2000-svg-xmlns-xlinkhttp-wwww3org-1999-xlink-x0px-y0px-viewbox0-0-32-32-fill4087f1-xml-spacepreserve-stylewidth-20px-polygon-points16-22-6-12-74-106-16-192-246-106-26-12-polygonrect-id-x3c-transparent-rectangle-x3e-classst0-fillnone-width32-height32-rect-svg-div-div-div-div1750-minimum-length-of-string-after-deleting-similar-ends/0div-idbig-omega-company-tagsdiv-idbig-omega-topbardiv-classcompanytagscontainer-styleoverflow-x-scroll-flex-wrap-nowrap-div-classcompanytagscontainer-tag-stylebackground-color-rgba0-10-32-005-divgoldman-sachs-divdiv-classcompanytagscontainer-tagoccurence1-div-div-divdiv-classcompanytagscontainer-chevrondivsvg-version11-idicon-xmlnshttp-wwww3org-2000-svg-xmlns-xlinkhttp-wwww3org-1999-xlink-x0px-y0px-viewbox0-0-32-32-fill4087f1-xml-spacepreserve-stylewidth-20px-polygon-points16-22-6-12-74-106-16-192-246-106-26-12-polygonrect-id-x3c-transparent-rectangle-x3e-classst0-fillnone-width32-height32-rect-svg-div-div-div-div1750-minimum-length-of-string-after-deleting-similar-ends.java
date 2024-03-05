class Solution {
    public int minimumLength(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j && s.charAt(i)==s.charAt(j)) {
            while(i+1<j && s.charAt(i)==s.charAt(i+1)) {
                i++;
            }
            while(j-1>i && s.charAt(j)==s.charAt(j-1)) {
                j--;
            }
            i++;
            j--;
        }
        return j-i+1;
    }
}