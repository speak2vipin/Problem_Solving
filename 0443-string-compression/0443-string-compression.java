class Solution {
    public int compress(char[] chars) {
        
		int st = 0;
		int N = chars.length;
		char temp = chars[0];
		int count = 1;
		for (int i = 1; i < N; i++) {
			if (chars[i] == temp) {
				count++;
				continue;
			} else {
				if (count == 1) {
					chars[st++] = temp;
				} else {
					chars[st++] = temp;
					String s = count+"";
					for(int j=0; j<s.length(); j++) {
						chars[st++] = s.charAt(j);
					}	
				}
				temp = chars[i];
				count = 1;
			}
		}
		chars[st++] = temp;
		if(count>1) {
			String s = count+"";
			for(int j=0; j<s.length(); j++) {
				chars[st++] = s.charAt(j);
			}	
		}
		return st;
    }
}