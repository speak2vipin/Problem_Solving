class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int l1 = s.length();
        int l2 = p.length();
        int j=-1;
        int pAscii [] = calculate(p);
        List<Integer> ans = new ArrayList<Integer> ();
        for(int i=l2-1; i<l1; i++) {
            j++;
            int sAscii [] = new int[26];
            System.arraycopy(pAscii, 0, sAscii, 0, 26);
            if(isAnagram(j, i, s, sAscii)) {
                ans.add(j);
            }
        }
        return ans;
    }
    
    boolean isAnagram(int st, int en, String s, int[]source) {
        
	        for(int i=st; i<en+1; i++) {
	            int index = s.charAt(i)-'a';
	            if(source[index]!=0) {
	                source[index]--;
	            } else {
	                return false;
	            }
	        }
	        return true;
	    
    }
        
    int[] calculate(String A) {
        int ascii[] = new int[26];
        for(int i=0; i<A.length(); i++) {
            int index = A.charAt(i)-'a';
            ascii[index] += 1; 
        }
        return ascii;
    }
}