class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int x = horizontalCut.length-1;
        int y = verticalCut.length-1;
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int rowcount = 1;
        int colcount = 1;
        int minCost = 0;
        while(x>-1 && y>-1) {
            if(horizontalCut[x]>verticalCut[y]) {
                minCost += colcount * horizontalCut[x--];
                rowcount++;
            } else {
                minCost += rowcount * verticalCut[y--];
                colcount++;
            }
        }
        while(x>-1) {
            minCost += colcount * horizontalCut[x--];
        }
        while(y>-1) {
            minCost += rowcount * verticalCut[y--];
        } 
        return minCost;
    }
    
}


