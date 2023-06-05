class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
       
        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];
        int N = coordinates.length;
        
        for(int i=1; i<N-1; i++) {
            
            int coordinate1[] = coordinates[i];
            int coordinate2[] = coordinates[i+1];
            
            int xDiff = (coordinate2[0] - coordinate1[0]);
            int yDiff = (coordinate2[1] - coordinate1[1]);
            
            if(dy==0 && yDiff!=0 || dy!=0 && yDiff==0) {
                return false;
            } else if(dy==0 && yDiff==0 || dy==0 && yDiff==0) {
            	continue;
            } else {
                if((double)dx/dy != (double)xDiff/yDiff) {
                    return false;
                }
            }
        }
        return true;
    }
}