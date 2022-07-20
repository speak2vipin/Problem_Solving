class Solution {
    public int numMatchingSubseq(String s, String[] words) {
	        int lastIndex = -1;
	        String sTemp = s;
	        int count = 0;
            Set<String> sSet = new HashSet<String>();
            Set<String> iSet = new HashSet<String>();
	        for(String s1 : words) {
                if(sSet.contains(s1)) {
                    count++;
                    continue;
                } else if(iSet.contains(s1)) {
                    continue;
                }
	            /*for(int i=0; i<s1.length();i++) {
	                int charIndex = sTemp.indexOf(s1.charAt(i));
	                if(charIndex == -1) {
                        iSet.add(s1);
	                    break;
	                } else {
	                	sTemp = sTemp.substring(charIndex+1);
	                }
	                if(i==s1.length()-1) {
                        sSet.add(s1);
	                    count++;
	                } else {
                        iSet.add(s1);
                    }
	            }
	            lastIndex = -1;
	            sTemp = s;
                */
                else {
                    if(isSequenceExist(s,s1)) {
                        count++;
                        sSet.add(s1);
                    } else {
                        iSet.add(s1);
                    }
                }
	        }
	        return count;   
    }
    
    public boolean isSequenceExist(String s1, String s2) {
        int i = 0;
        int j = 0;
        while(i<s1.length() && j<s2.length()) {
            if(s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if(j==s2.length()) {
            return true;
        }
        return false;
    }
}
