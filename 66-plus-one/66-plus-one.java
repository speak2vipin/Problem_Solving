class Solution {
    public int[] plusOne(int[] digits) {
        boolean isZero = false;
        for(int i=digits.length-1;i>=0;i--) {
            if(digits[i] + 1 == 10) {
                isZero = true;
                digits[i] = 0;
            } else {
                isZero = false;
                digits[i] = digits[i] + 1;
                break;
            }
        }
        if(isZero) {
            int res[] = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}