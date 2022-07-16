class Solution {
    public String longestCommonPrefix(String[] strs) {  
        if(strs.length==1) {
            return strs[0];
        }
        String result = "";
        String temp = null;         

		for (int i = 0; i < strs[0].length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				if (i<strs[j].length() && strs[j].charAt(i) == strs[0].charAt(i)) {
					if (j == strs.length - 1) {
						result = result + strs[0].charAt(i);
					}
				} else {
					return result;
				}
			}
		}

		return result;

    }
}