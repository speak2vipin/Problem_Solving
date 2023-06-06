class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        int N = arr.length;
        for(int i=2; i<N; i++) {
            if((arr[i] - arr[i-1]) != diff) {
                return false;
            }
        }
        return true;
    }
}