class Solution {
    
    public boolean checkInclusion(String s1, String s2) {

		int l1 = s1.length();
		int l2 = s2.length();
		if (l2 < l1) {
			return false;
		}

		int letters_s1[] = new int[26];
		
		for (int i = 0; i < l1; i++) {
			letters_s1[s1.charAt(i) - 'a'] += 1;
		}
		int letters_s2[] = new int[26];
		for (int i = 0; i < l1; i++) {
			letters_s2[s2.charAt(i) - 'a'] += 1;
		}
		if (check(letters_s1,letters_s2)) {
			return true;
		}
		
		for (int i = l1; i < l2; i++) {
			int indexLeft = s2.charAt(i - l1) - 'a';
			int indexRight = s2.charAt(i) - 'a';
			letters_s2[indexLeft] -= 1;
			letters_s2[indexRight] += 1;

			if (check(letters_s1, letters_s2)) {
				return true;
			}
		}
		return false;
	}

	boolean check(int letters_s1[], int letters_s2[]) {
		for (int i = 0; i < 26; i++) {
			if (letters_s1[i] != letters_s2[i]) {
				return false;
			}
		}
		return true;
	}
}