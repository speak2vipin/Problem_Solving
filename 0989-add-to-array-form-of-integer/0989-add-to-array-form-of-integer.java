class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        
		int len1 = num.length - 1;
		String ks = k + "";
		int len2 = ks.length() - 1;
		int carry = 0;
		List<Integer> ans = new ArrayList<Integer>();
		while (len1 >= 0 || len2 >= 0) {
			int sum = carry;
			if (len1 >= 0) {
				sum += num[len1--];
			}
			if (len2 >= 0) {
				sum += ks.charAt(len2--) - '0';
			}
			carry = sum / 10;
			sum = sum % 10;
			ans.add(sum);
		}
		if (carry != 0) {
			ans.add(carry);
		}
		Collections.reverse(ans);
		return ans;

	
        
    }
}