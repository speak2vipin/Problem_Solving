class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        if(n==1) {
            return s;
        }
        
        int i = 0;
        int j = 0;
        char charArray[] = s.toCharArray();
        while(i<n) {
            if(s.charAt(i)=='1') {
                charArray[j] = s.charAt(i);
                if(i!=j) {
                    charArray[i] = '0';
                }
                j++;
            } 
            i++;
        }
        if(j!=n) {
            charArray[n-1] = charArray[j-1];
            charArray[j-1] = '0';
        }
        return new String(charArray);
    }
}