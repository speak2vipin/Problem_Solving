class Solution {
    // TC: O(M*logN)
    public int countNegativesByBinarySearch(int[][] grid) {
        int ans = 0;
        int N = grid[0].length-1;
        for(int temp[] :  grid) {
            int index = binarySearch(temp);
            ans += (index==-1 ? 0 : (N-index+1));
        }
        return ans;
    }
    
    int binarySearch(int grid[]) {
        int st = 0;   
        int en = grid.length-1;
        int index = -1;
        while(st<=en) {
            int mid = (st+en)/2;
            if(grid[mid]<0) {
                index = mid;
                en = mid-1; 
            } else {
                st = mid+1;
            }
        }
        return index;
    }
    
    public int countNegatives(int[][] grid) {
        int ans = 0;
        int N = grid[0].length-1;
        int n = N;
        for(int temp[] :  grid) {
            while(n>-1 && temp[n]<0) {
                n--;
            }
            
            ans = ans + (N-n);
            
        }
        return ans;
    }
}