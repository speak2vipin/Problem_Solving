class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int len = books.length;
        int memo[][] = new int[len][shelfWidth+1];
        return helper(books, shelfWidth, memo, 0, shelfWidth, 0);
        
    }
    
    int helper(int books[][], int width, int memo[][], int i, int remainingWidth, int maxHeight) {
        int []currentBook = books[i];
        int maxHeightUpdated = Math.max(maxHeight, currentBook[1]);
        
        if(i==books.length-1) {
            if(remainingWidth>=currentBook[0]) {
                return maxHeightUpdated;
            }
            return maxHeight + currentBook[1];
        }
        
        if(memo[i][remainingWidth]!=0) {
            return memo[i][remainingWidth];
        }
        
        int height1 = maxHeight + helper(books, width, memo, i+1, width-currentBook[0], currentBook[1]);
        
        if(remainingWidth>=currentBook[0]) {
            int height2 = helper(books, width, memo, i+1, remainingWidth-currentBook[0], maxHeightUpdated);
            return memo[i][remainingWidth] = Math.min(height1, height2);
        }
        return memo[i][remainingWidth] = height1;
    }
}