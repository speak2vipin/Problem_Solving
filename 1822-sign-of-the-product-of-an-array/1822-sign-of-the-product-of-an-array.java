class Solution {
    public int arraySign(int[] nums) {
        int negativeSign = 0;
        for(int num : nums) {
            if(num<0) {
                negativeSign++;
            } else if(num==0) {
                return 0;
            }
        }
        return (negativeSign%2)==0 ? 1 : -1;
        
    }
}