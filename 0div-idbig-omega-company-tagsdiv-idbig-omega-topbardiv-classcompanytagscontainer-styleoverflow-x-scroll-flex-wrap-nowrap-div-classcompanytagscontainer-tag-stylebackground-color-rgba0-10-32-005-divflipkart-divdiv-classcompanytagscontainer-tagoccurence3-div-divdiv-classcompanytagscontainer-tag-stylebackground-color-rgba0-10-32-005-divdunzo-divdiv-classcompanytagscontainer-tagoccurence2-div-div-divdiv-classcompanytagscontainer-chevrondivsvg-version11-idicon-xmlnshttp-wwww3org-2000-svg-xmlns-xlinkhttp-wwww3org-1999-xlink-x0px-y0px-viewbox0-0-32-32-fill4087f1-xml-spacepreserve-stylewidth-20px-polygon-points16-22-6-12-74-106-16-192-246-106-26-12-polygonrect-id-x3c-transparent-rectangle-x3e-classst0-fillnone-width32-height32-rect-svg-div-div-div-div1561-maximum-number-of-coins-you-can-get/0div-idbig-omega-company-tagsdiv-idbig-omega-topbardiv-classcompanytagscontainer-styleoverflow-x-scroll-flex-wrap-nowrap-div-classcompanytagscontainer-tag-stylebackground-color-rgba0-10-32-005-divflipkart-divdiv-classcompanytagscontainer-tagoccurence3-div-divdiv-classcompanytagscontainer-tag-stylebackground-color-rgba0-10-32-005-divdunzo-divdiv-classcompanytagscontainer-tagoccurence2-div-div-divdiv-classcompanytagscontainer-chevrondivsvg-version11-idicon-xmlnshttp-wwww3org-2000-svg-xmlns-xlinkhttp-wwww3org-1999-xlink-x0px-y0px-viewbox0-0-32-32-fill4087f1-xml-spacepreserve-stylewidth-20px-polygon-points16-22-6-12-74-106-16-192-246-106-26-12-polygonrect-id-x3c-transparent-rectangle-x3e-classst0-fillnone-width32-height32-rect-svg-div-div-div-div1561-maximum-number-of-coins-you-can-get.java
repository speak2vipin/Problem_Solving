class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length-1;
        int count = 0;
        
        int i=0;
        int j=n;
        while(i+1<j) {
            count += piles[j-1];
            i++;
            j=j-2;
        }
        return count;
        
    }
}