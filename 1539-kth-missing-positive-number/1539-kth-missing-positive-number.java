class Solution {
    public int findKthPositive(int[] arr, int k) {
        int temp = 1;
        int N = arr.length;
        for(int i=0; i<N; ) {
            if(k>0) {
                if(arr[i]!=temp) {
                    k--;
                } else {
                    i++;
                }
                temp++;
            } else {
                break;
            }
        }
                    
        while(k>0) {
            k--;
            temp++;
        }
        
        return temp-1;
    }
}