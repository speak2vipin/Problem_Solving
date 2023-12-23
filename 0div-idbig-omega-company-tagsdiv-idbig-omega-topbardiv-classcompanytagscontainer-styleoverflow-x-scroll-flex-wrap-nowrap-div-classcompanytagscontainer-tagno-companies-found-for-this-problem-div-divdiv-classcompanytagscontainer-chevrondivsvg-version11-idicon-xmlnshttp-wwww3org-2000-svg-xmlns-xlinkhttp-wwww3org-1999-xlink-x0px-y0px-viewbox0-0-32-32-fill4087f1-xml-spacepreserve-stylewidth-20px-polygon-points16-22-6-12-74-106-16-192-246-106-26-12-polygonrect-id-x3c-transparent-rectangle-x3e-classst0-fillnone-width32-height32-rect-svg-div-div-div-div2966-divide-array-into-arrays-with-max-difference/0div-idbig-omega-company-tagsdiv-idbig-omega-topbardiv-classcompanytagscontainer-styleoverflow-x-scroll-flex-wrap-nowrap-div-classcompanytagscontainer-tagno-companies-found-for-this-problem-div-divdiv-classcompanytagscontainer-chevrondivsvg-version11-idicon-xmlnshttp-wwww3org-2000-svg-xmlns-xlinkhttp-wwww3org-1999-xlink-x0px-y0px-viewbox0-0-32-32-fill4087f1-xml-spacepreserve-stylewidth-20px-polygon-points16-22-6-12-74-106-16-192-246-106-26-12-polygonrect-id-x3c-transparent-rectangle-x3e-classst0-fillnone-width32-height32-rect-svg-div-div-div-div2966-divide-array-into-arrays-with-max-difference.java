class Solution {
    public int[][] divideArrayMy(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int N = n/3;
        int ans[][] = new int[N][3];
        int temp[] = null;
        int index = 0;
        int min = -1;
        for(int i=0; i<n; i++) {
            if((i%3)==0) {
                temp = new int[3];
                ans[index++] = temp;
                min = nums[i];
            } else {
                if(nums[i] - min > k) {
                    return new int[][]{};
                }
            }
            temp[i%3] = nums[i];
        }
        return ans;
    }
    
    public int[][] divideArray(int[] nums, int k) {
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