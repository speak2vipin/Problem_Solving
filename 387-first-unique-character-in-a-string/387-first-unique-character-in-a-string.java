class Solution {
    public int firstUniqChar(String s) {  
        int index[] = new int[26];
        char[] sArray = s.toCharArray();
        for(char temp : sArray) {
            index[temp-'a'] += 1; 
        }
        for(char temp : sArray) {
            if(index[temp-'a']==1) {
                return s.indexOf(temp);
            }
        }
        
       /* for(int i=0; i<s.length();i++) {
            if(s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i))) {
        	     return i;	
        	}
        }*/
        return -1; 
    }
}