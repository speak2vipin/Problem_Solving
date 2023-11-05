class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int i = 0;
        int j = 1;
        int tempK = k;
        int max = Integer.MIN_VALUE;
        
        for(int a : arr) {
            max = Math.max(max, a);
        }
        while(true) {
            if(arr[i]==max) {
                return max;
            }
            if(arr[i%n]>=arr[j%n]) {
                tempK--;
                if(tempK==0) {
                    return arr[i];
                }
            } else {
                i = j;
                tempK = k-1;
                if(tempK==0) {
                    return arr[i];
                }
            }
            j++;
        }
    }
}