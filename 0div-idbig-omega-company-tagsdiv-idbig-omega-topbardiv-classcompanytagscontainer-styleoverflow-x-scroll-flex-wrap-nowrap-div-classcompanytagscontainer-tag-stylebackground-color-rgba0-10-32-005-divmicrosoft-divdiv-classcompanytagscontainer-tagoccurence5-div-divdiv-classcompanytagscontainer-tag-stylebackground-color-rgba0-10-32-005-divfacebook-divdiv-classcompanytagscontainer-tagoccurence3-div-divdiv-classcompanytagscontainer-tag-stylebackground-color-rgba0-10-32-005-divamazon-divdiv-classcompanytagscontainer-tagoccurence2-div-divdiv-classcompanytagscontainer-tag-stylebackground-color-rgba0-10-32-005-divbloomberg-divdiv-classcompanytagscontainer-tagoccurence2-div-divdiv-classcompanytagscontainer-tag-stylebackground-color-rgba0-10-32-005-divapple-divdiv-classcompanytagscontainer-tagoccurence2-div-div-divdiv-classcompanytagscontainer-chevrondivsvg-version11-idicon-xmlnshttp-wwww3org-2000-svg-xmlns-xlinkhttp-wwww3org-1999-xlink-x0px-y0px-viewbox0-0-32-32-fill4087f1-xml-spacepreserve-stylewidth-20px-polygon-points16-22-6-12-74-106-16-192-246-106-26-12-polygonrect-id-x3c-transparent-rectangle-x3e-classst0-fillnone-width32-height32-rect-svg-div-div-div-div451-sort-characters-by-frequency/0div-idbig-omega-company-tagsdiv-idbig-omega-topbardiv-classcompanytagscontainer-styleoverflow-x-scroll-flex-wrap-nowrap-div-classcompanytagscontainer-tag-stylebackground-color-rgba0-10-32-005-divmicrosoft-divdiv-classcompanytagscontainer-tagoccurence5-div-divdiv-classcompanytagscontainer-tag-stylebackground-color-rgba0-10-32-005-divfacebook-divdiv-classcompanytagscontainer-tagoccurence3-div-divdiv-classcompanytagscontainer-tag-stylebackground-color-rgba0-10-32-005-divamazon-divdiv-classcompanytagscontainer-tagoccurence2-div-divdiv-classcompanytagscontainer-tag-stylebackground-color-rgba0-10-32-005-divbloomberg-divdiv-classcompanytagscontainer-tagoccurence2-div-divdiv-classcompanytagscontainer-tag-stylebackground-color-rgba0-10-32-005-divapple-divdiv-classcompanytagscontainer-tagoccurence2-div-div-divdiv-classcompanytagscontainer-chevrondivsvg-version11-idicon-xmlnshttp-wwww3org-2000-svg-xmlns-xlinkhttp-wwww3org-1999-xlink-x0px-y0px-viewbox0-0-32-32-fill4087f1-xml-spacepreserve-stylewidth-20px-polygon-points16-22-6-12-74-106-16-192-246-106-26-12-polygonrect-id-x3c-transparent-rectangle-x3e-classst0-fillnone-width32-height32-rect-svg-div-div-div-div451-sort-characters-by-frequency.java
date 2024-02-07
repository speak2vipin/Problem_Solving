class Solution {
    public String frequencySort(String s) {
	    int temp[][] = new int[128][];
		
		for(int i=0; i<128; i++) {
			temp[i] = new int[] {-1,0};
		}
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - '0';
			temp[index][0] = index;
			temp[index][1]++;
		}
		Arrays.sort(temp, (x, y) -> (y[1] - x[1]));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 128; i++) {
			if (temp[i][0] != -1) {
				for(int j=0; j<temp[i][1]; j++) {
					sb.append((char) ('0' + temp[i][0]));
				}
			}
		}
		return sb.toString();
	    }
}