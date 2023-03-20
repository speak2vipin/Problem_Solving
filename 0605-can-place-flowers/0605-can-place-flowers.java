class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) {
            return true;
        }
        int N = flowerbed.length;
        for(int i=0; i<N; i++) {
            boolean leftAvailable = ((i==0 || flowerbed[i-1]!=1) ? true : false);
            boolean rightAvailable = ((i==N-1 || flowerbed[i+1]!=1) ? true : false);
            if(flowerbed[i]==0 && leftAvailable && rightAvailable) {
                flowerbed[i] = 1;
                n--;
                if(n==0) {
                    return true;
                }
            }
        }
        return false;
    }
}