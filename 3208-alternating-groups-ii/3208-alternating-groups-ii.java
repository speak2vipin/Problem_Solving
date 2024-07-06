class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int last = colors[0];
        int count = 1;
        int ans = 0;
        for(int i=1; i<colors.length; i++) {
            count = colors[i]!=last?++count:1;
            last = colors[i];
            if(count>=k) {
                ans++;
            }
        }
        for(int i=0; i<k-1; i++) {
            count = colors[i]!=last?++count:1;
            last = colors[i];
            if(count>=k) {
                ans++;
            }
        }
        return ans;
        
    }
}