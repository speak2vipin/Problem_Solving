class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int N = nums.length;
        long continousZero = 0;
        long count = 0;
        for(int i=0; i<N; i++) {
            if(nums[i]==0){
                continousZero++;
            } else {
                count += ((continousZero+1)*continousZero)/2;
                continousZero = 0;
            }
        }
        if(continousZero!=0) {
            count += ((continousZero+1)*continousZero)/2;
        }
        return count;
    }
}