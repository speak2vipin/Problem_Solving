class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(possibleHeight(red, blue), possibleHeight(blue, red));
        
    }
    
    int possibleHeight(int x, int y) {
        int count = 1;
        boolean flag = true;
        while((flag && x-count>=0) || (!flag && y-count>=0)) {
            if(flag) {
                x -= count;
            } else {
                y -= count;
            }
            flag = !flag;
            count++;
        }
        return count-1;
    }
}