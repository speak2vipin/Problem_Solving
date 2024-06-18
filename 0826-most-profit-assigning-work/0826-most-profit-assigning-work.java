class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int x[][] = new int[n][2];
        for(int i=0; i<n; i++) {
            x[i][0] = difficulty[i];
            x[i][1] = profit[i];
        }
        Arrays.sort(x, (x1,x2)->Integer.compare(x2[1], x1[1]));
      
        Integer[] w = Arrays.stream(worker)
                        .mapToObj(Integer::valueOf)
                        .toArray(Integer[]::new);
        
        Arrays.sort(w, Collections.reverseOrder());
        int sum = 0;
        int i = 0;
        int j = 0;
        while(i<n) {
            int maxDiff[] = x[i];
            while(j<w.length && maxDiff[0]<=w[j]) {
                sum += maxDiff[1];
                j++;
            }
            i++;
        }
        return sum;
    }
}