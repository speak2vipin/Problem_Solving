class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer>ans = new ArrayList<>();
        List<Integer>row = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++) {
            int min = 100001;
            for(int j=0; j<n; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            row.add(min);
        }
        List<Integer>col = new ArrayList<>();
        for(int j=0; j<n; j++) {
            int max = 0;
            for(int i=0; i<m; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            if(row.contains(max)) {
                ans.add(max);
            }
        }
        return ans;
        
    }
}