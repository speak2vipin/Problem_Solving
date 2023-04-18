class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int l1 = word1.length();
        int l2 = word2.length();
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        int j = 0;
        boolean flag = true;
        
        while (l1>i && l2>j) {
        	if(flag) {
                sb.append(word1.charAt(i));
                i++;
            } else {
                sb.append(word2.charAt(j));
                j++;
            }
        	flag = !flag;			
		}
        if(l1>i) {
            sb.append(word1.substring(i));
        } else {
            sb.append(word2.substring(j));
        }
        return sb.toString(); 
    
        
    }
}