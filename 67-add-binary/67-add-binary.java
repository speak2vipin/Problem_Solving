class Solution {
    public String addBinary(String A, String B) {
        /**
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
        **/
        int aLen = A.length();
		int bLen = B.length();
		String Ans = "";
		char carry = '0';
		String minTemp;
		String maxTemp;
		if(aLen>bLen) {
			minTemp = B;
			maxTemp = A;
		} else {
			minTemp = A;
			maxTemp = B;
		}
		
		int i,k;
		for (i = minTemp.length()-1, k = maxTemp.length()-1 ; i > -1; i--, k--) {
			if (minTemp.charAt(i) == '0' && maxTemp.charAt(k) == '0') {
				if (carry == '0') {
					Ans = '0' + Ans;
				} else {
					Ans = '1' + Ans;
					carry = '0';
				}
			} else if (minTemp.charAt(i) == '0' && maxTemp.charAt(k) == '1') {
				if (carry == '0') {
					Ans = '1' + Ans;
				} else {
					Ans = '0' + Ans;
					carry = '1';
				}
			} else if (minTemp.charAt(i) == '1' && maxTemp.charAt(k) == '0') {
				if (carry == '0') {
					Ans = '1' + Ans;
				} else {
					Ans = '0' + Ans;
					carry = '1';
				}
			} else if (minTemp.charAt(i) == '1' && maxTemp.charAt(k) == '1') {
				if (carry == '0') {
					Ans = '0' + Ans;
					carry = '1';
				} else {
					Ans = '1' + Ans;
					carry = '1';
				}
			}
		}
		
		for (; k > -1; k--) {
				if (maxTemp.charAt(k) == '0' && carry == '0') {
					Ans = '0' + Ans;
				} else if (maxTemp.charAt(k) == '1' && carry == '0') {
					Ans = '1' + Ans;
				} else if (maxTemp.charAt(k) == '0' && carry == '1') {
					Ans = '1' + Ans;
					carry = '0';
				} else if (maxTemp.charAt(k) == '1' && carry == '1') {
					Ans = '0' + Ans;
					carry = '1';
				}
		}
		if (carry == '1') {
			Ans = '1' + Ans;
		}
		return Ans;	
    
    }
}