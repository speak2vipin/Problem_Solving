class Solution {
    public void rotate(int[] nums, int K) {
        K = K%nums.length;
        int N = nums.length-1;
        reverseArray(nums,0,N);
        reverseArray(nums,0,K-1);
        reverseArray(nums,K,N);
        
    }
    void reverseArray(int[]A, int start, int end) {
       int temp;
       while(start<end) {
           temp = A[start];
           A[start] = A[end];
           A[end] = temp;
           start++;
           end--;
       } 
    }
}