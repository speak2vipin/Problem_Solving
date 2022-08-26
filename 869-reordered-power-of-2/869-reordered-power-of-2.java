class Solution {
    public boolean reorderedPowerOf2(int n) {
        if(n==1) {
            return true;
        }
        String s1 = Integer.toString(n);
		char[] c1 = s1.toCharArray();
		Arrays.sort(c1);
		s1 = new String(c1);
		for (int i = 0; i < 32; i++) {
			char[] c2 = Integer.toString(1 << i).toCharArray();
			Arrays.sort(c2);
			String s2 = new String(c2);
			if (s1.equals(s2)) {
				return true;
			}
		}
		return false;      
    }
}