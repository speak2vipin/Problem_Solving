class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int N = costs.length;
        int count = 0;
        for(int i=0; i<N; i++) {
            coins -= costs[i];
            if(coins<0) {
                break;
            }
            count++;
        }
        return count;
    }
}