class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
       /* Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        int N = arr.length;
        for(int i=2; i<N; i++) {
            if((arr[i] - arr[i-1]) != diff) {
                return false;
            }
        }
        return true;
        */
        int N = arr.length;
        int minValue = Arrays.stream(arr).min().getAsInt();
        int maxValue = Arrays.stream(arr).max().getAsInt();
        if(minValue-maxValue==0) {
            return true;
        }
        if((maxValue-minValue)%(N-1)!=0) {
            return false;
        }
        int diff = (maxValue-minValue)/(N-1);
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            if((arr[i]-minValue)%diff !=0) {
                return false;
            }
            set.add(arr[i]);
        }
        return set.size()==N;
    }
}