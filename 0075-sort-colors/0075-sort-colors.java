class Solution {
    public void sortColors(int[] nums) {
        mergesort(nums, 0, nums.length-1);
    }
    
    void mergesort(int nums[], int st, int en) {
        if(st<en) {
            int m = (st+en)/2;
            mergesort(nums, st, m);
            mergesort(nums,m+1, en);
            mergearray(nums, st, m, en);
        }
    }
    
    void mergearray(int nums[], int l, int m, int r) {
        int L[] = new int[m-l+1];
        int R[] = new int[r-m];
        for(int i=l; i<m+1; i++) {
            L[i-l] = nums[i];
        }
        for(int i=m+1; i<=r; i++) {
            R[i-m-1] = nums[i];
        }
        int i=0,j=0, k=0;
        while(i<L.length && j<R.length) {
            if(L[i]<=R[j]) {
                nums[l++] = L[i++];
            } else {
                nums[l++] = R[j++];
            }
        }
        while(i<L.length) {
            nums[l++] = L[i++];
            k++;
        }
        while(j<R.length) {
            nums[l++] = R[j++];
            k++;
        }
    }
}