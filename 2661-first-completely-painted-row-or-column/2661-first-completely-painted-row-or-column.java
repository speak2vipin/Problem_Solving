class Solution {
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
        int row[] = new int[N];
        int col[] = new int[M];

        for(int i=0; i<arr.length; i++) {
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