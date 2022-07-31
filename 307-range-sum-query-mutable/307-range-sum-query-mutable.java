class NumArray {
    
    int[] nums;
    double sqrt;
    int block;
    int[]b;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.sqrt = Math.sqrt(nums.length);
        this.block = (int)Math.ceil(nums.length/sqrt);
        b = new int[block];
        for(int i=0;i<nums.length;i++) {
        	b[(int)(i/block)]+=nums[i];
        }
        
    }
    
    public void update(int i, int val) {
        int b_l = i / block;
	    b[b_l] = b[b_l] - nums[i] + val;
	    nums[i] = val;
    }
    
    public int sumRange(int left, int right) {
        int sum =0;
        int startblock = (int)(left/block);
        int endblock = (int)(right/block);
        if(startblock==endblock) {
            for(int i=left; i<=right;i++) {
                sum+=nums[i];
            }
        } else {
            for(int i=left;i<(startblock+1)*block;i++) {
            	sum+=nums[i];
            }
           
            for(int i=startblock+1;i<endblock;i++) {
        	    sum+=b[i];
            }
            for(int i=endblock*block;i<=right;i++) {
            	sum+=nums[i];
            }
            	
        }
        return sum;
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */