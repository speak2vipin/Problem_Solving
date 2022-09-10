class Solution {
   public String decodeString(String s) {
      
		while (s.lastIndexOf('[') != -1) {
			int i = s.lastIndexOf('[');
			int count = 0;
			char c = s.charAt(i - 1);
			int tempCount = 0;

			while (c > 47 && c < 58) {
				
				tempCount += (c - '0') * Math.pow(10, count);
				count++;
				if(i - 1 - count>-1)
					c = s.charAt(i - 1 - count);
				else
					break;
			}
			int k = i + mod(s.substring(i + 1));
			s = s.substring(0, i - count) + recurString(s.substring(i + 1, k), tempCount, "") + s.substring(k+1);
		}
		return s;
	}

	  String recurString(String s, int A, String temp) {
		if (A == 1) {
			return temp + s;
		}
		return recurString(s, A - 1, temp + s);
	}

	 int mod(String s) {
		int i = 0;
		while (s.charAt(i) != ']') {
			i++;
		}
		return i+1;
	}
}