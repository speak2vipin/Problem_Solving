class Solution {
    public int partitionString(String s) {
        
        int count = 0;
        int i=0;
        int l = s.length();
        HashSet<Character> set = new HashSet<>();
        while(i<l) { 
        	count++;
            while(i<l) {
                if(set.add(s.charAt(i))) {
                	i++;
                } else {
                	break;
                }
            }
            set.clear();
        }
        return count;
        
    
        
    }
}