class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int N = n/3;
        int ans[][] = new int[N][3];
        int index = 0;
        int st = 0;
        while(st<n) {
            if(nums[st+2]-nums[st]>k) {
                return new int[][]{};
            }
            ans[index++] = new int[] {nums[st], nums[st+1], nums[st+2]};
            st += 3;
        }
        return ans;
    }
    
    public int[][] divideArrayPrev(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans[][] = new int[n/3][];
        for(int i=2; i<n; i+=3) {
            if(nums[i]-nums[i-2]>k) {
                return new int[][]{};
            }
            ans[i/3] = new int[] {nums[i-2], nums[i-1], nums[i]};
        }
        return ans;
    }
}