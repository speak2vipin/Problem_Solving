class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (r1, r2)->Integer.compare(r1[0], r2[0]));
        for(int range[] : ranges) {
            int st = 0;
            while(range[0]+st<=range[1]) {
                if(left==range[0]+st) {
                    left++;
                }
                st++;
            }
        }
        return left>right;
    }
}