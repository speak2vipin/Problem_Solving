class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max = Integer.MIN_VALUE;
        
        while(i<j) {
            int tempArea = Math.min(height[i], height[j]) * (j-i);
            max = Math.max(max, tempArea);
            if(height[i]>height[j]) {
                j--;    
            } else {
                i++;
            }
        }
        return max;
    }
}