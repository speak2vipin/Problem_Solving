class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            leftProduct = leftProduct==0 ? 1 : leftProduct;
            rightProduct = rightProduct==0 ? 1 : rightProduct;
            leftProduct = nums[i] * leftProduct;
            rightProduct = nums[n-1-i] * rightProduct;
            maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        }
        return maxProduct;
    }
    
    public int maxProductBruteforce(int[] nums) {
        int n = nums.length;
        int maxProduct = nums[0];
        for(int i=0; i<n; i++) {
            int product = 1;
            for(int j=i; j<n; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }
    
}