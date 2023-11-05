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
            if(arr[i]==max || tempK==0) {
                return arr[i];
            }
            if(arr[i%n]>=arr[j%n]) {
                tempK--;
            } else {
                i = j;
                tempK = k-1;
            }
            j++;
        }
    }
}