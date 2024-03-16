class Solution {
    public int maxProductOptimize(int[] nums) {
        int max_product = nums[0];
        int temp_product = nums[0];
        int n = nums.length;
        for(int i=1; i<n; i++) {
            if(temp_product*nums[i]>=temp_product) {
                temp_product = Math.max(temp_product*nums[i], nums[i]);
            } else {
                temp_product = nums[i];
            }
            max_product = Math.max(max_product, temp_product);
        }
        return max_product;
    }
    
    public int maxProduct(int[] nums) {
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