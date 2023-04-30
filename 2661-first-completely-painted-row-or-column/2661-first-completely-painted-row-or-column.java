class Solution {
    // Logic :  
    // Store position of each number in matrix
    // Iterate arr and 
        // Check the count of each row and column
        // If row==(columns size) 
            // return index;
        // else if col== (rows size)
            // return index
    
    // TC- O(N*M + len) ~ O(N*M)
    // SC- O(N*M)
    
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        int N = mat.length;
        int M = mat[0].length;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map.put(mat[i][j], new int[] {i, j});
            }
        }
        
        int count = 0;
        // WILL STORE NUMBER OF COLUMNS TO A ROW
        int row[] = new int[N];
        // WILL STORE NUMBER OF ROWS TO A COLUMN
        int col[] = new int[M];
        int len = arr.length;
        for(int i=0; i<len; i++) {
            int index[] = map.get(arr[i]);
            int x = index[0];
            int y = index[1];
            row[x]++;
            if(row[x]==M) {
                return i;                
            }
            col[y]++;
            if(col[y]==N) {
                return i;
            }
        }
        return -1;   
    }      
}