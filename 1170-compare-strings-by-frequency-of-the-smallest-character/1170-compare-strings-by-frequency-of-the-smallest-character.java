class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
		int[] wordsF = new int[words.length];
		int[] queriesF = new int[queries.length];
		char c = '\u0000';
		int j = 0;
		for (String w : words) {
			wordsF[j] = calculateFrequency(w);
			j++;
		}
		j = 0 ;
		for (String q : queries) {
			queriesF[j] = calculateFrequency(q);
			j++;
		}
		for(int i=0; i<queriesF.length;i++) {
			int resultC = 0;
			for(int k=0; k<wordsF.length;k++) {
				if(wordsF[k]>queriesF[i]) {
					resultC++;
				}
			}
			queriesF[i] = resultC;
		}
		return queriesF;
    }
    
    int calculateFrequency(String s) {
		char c = '\u0000';
		int count = 0;
		for (int i = 0; i < s.length(); i++) {

			if (i == 0) {
				c = s.charAt(i);
				count++;
			} else {
				if (c == s.charAt(i)) {
					count++;
				} else if (c > s.charAt(i)) {
					c = s.charAt(i);
					count = 1;
				}
			}
		}
		return count;
	}
}