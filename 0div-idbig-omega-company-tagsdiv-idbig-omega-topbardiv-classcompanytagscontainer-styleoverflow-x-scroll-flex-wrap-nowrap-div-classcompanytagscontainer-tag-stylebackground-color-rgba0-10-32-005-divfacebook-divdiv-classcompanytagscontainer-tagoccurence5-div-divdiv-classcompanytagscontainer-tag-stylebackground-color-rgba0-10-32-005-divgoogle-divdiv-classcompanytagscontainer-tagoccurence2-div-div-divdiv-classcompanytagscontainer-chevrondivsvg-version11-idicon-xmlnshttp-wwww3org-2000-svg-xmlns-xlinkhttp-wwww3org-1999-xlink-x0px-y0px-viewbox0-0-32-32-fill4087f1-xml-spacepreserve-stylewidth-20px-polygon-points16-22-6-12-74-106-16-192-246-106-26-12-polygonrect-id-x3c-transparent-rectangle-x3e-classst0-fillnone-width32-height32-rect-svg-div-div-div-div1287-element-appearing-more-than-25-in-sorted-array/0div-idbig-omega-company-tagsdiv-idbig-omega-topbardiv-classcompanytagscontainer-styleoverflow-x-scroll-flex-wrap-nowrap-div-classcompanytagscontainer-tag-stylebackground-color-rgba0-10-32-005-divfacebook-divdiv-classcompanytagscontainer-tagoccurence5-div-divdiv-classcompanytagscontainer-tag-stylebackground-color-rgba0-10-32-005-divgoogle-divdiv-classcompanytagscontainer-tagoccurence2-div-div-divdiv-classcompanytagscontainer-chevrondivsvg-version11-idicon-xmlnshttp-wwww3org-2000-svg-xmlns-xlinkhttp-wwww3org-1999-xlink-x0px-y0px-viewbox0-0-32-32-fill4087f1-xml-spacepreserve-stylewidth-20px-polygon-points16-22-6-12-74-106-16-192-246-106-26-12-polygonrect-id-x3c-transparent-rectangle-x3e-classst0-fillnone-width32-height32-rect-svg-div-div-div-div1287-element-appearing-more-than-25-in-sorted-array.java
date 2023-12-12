class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int targetCount = (n + 4)/4;
        int val = arr[0];
        int tempCount = 1;
        for(int i=1; i<n; i++) {
            if(val==arr[i]) {
                tempCount++;
            } else {
                val = arr[i];
                tempCount = 1;
            }
            if(tempCount>=targetCount) {
                return val;
            }
        }
        if(tempCount>=targetCount) {
                return val;
        }
    
        return -1;
        
    }
}