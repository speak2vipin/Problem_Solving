class Solution {
    public String longestPalindrome(String s) {
	/*	String s1 = "";
		String s2 = "";
		int k;
		for (int i = 0; i < s.length(); i++) {
			k = i;
			if(s1.length()==0) {
				s1 = s.substring(i, i+1);
			}
			for (int j = s.length() - 1; j > i; j--) {
				int l = j;
				k=i;
				while (s.charAt(k) == s.charAt(l)) {
					
					if(k>=l) {
						s2 = s.substring(i, j+1);
						System.out.println(s2);
						if(s1.length()<s2.length()) {
							s1 = s2;
						}
						
						break;
					}
					k++;
					l--;
				}
			}

		}
		return s1; */
        int N = s.length();
        int len = 0;
        String ans = ""+s.charAt(0);
        for(int i=0;i<N;i++) {
            String odd = checkPalindrome(s, i-1, i+1);
            String even = checkPalindrome(s, i, i+1);
            ans = ans.length()<odd.length() ? odd : ans;
            ans = ans.length()<even.length() ? even : ans;
        }
        return ans;
    }
    String checkPalindrome(String S, int start, int end) {
        boolean isProcessed = false;
        int N = S.length();
        while(start>-1 && end<N && S.charAt(start)==S.charAt(end)) {
            isProcessed = true;
            start--;
            end++;
            continue;
        }
        return isProcessed ? S.substring(++start, end--) : "";
    }
    
}