class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        int l = 0;
        int r = n-1;
        int index = n-1;
        while(l<=r) {
            int ls = nums[l]*nums[l];
            int rs = nums[r]*nums[r];
            if(ls<=rs) {
                res[index--] = rs;
                r--;
            } else {
                res[index--] = ls;
                l++;
            }
        }
        return res;
        
    }
}