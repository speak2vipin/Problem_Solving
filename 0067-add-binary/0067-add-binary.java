class Solution {
    public String addBinary(String a, String b) {
		int l1 = a.length() - 1;
		int l2 = b.length() - 1;
		int l = l1 > l2 ? l2 : l1;
		String ans = "";
		char carry = '0';
		while (l1 > -1 && l2 > -1) {
			char c1 = a.charAt(l1);
			char c2 = b.charAt(l2);
			if (c1 == '1' && c2 == '1') {
				if (carry == '1') {
					ans = '1' + ans;
					carry = '1';
				} else {
					ans = '0' + ans;
					carry = '1';
				}
			} else if (c1 == '0' && c2 == '0') {
				if (carry == '1') {
					ans = '1' + ans;
					carry = '0';
				} else {
					ans = '0' + ans;
				}
			} else {
				if (carry == '1') {
					ans = '0' + ans;
					carry = '1';
				} else {
					ans = '1' + ans;
					carry = '0';
				}
			}
			l1--;
			l2--;
		}
		if (l1 == -1) {
			while (l2 > -1) {
				char temp = b.charAt(l2);
				if (temp == '1' && carry == '1') {
					ans = '0' + ans;
					carry = '1';
				} else if (temp == '0' && carry == '0') {
					ans = '0' + ans;
				} else {
					ans = '1' + ans;
					carry = '0';
				}
				l2--;
			}
		} else if (l2 == -1) {
			while (l1 > -1) {
				char temp = a.charAt(l1);
				if (temp == '1' && carry == '1') {
					ans = '0' + ans;
					carry = '1';
				} else if (temp == '0' && carry == '0') {
					ans = '0' + ans;
				} else {
					ans = '1' + ans;
					carry = '0';
				}
				l1--;
			}
		}
		if(carry=='1') {
			ans = '1'+ans;
		}
		return ans;
	}
}