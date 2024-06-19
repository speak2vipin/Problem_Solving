class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int st = 1; // min bloomDay[i] value
        int en = 0;
        for(int b : bloomDay) {
            en = Math.max(en, b);
        }
        int minDays = -1;
        while(st<=en) {
            int mid = (st + en)/2;
            if(getBloomedFlowerBouquets(bloomDay, mid, k)>=m) {
                minDays = mid;
                en = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return minDays;
        
    }
    
    int getBloomedFlowerBouquets(int bloomDay[], int mid, int k) {
        int count = 0;
        int noOfBouquets = 0;
        for(int i=0; i<bloomDay.length; i++) {
            if(bloomDay[i]<=mid) {
                count++;
            } else {
                count = 0;
            }
            if(count==k) {
                noOfBouquets++;
                count = 0;
            }
        }
        return noOfBouquets;
    }
}