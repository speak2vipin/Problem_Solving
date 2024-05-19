class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int l1 = nums.length;
        int specialPrefix[] = new int[l1];
        for(int i=1; i<l1; i++) {
            if(nums[i]%2==0 && nums[i-1]%2==0) {
                specialPrefix[i] = specialPrefix[i-1] + 1;
            } else if(nums[i]%2!=0 && nums[i-1]%2!=0) {
                specialPrefix[i] = specialPrefix[i-1] + 1;;
            } else {
                specialPrefix[i] = specialPrefix[i-1];
            }
        }
        int l2 = queries.length;
        boolean result[] = new boolean[l2];
        for(int i=0; i<l2; i++) {
            if((specialPrefix[queries[i][1]] - specialPrefix[queries[i][0]])==0) {
                result[i] = true;
            }
        }
        return result;
    }
}