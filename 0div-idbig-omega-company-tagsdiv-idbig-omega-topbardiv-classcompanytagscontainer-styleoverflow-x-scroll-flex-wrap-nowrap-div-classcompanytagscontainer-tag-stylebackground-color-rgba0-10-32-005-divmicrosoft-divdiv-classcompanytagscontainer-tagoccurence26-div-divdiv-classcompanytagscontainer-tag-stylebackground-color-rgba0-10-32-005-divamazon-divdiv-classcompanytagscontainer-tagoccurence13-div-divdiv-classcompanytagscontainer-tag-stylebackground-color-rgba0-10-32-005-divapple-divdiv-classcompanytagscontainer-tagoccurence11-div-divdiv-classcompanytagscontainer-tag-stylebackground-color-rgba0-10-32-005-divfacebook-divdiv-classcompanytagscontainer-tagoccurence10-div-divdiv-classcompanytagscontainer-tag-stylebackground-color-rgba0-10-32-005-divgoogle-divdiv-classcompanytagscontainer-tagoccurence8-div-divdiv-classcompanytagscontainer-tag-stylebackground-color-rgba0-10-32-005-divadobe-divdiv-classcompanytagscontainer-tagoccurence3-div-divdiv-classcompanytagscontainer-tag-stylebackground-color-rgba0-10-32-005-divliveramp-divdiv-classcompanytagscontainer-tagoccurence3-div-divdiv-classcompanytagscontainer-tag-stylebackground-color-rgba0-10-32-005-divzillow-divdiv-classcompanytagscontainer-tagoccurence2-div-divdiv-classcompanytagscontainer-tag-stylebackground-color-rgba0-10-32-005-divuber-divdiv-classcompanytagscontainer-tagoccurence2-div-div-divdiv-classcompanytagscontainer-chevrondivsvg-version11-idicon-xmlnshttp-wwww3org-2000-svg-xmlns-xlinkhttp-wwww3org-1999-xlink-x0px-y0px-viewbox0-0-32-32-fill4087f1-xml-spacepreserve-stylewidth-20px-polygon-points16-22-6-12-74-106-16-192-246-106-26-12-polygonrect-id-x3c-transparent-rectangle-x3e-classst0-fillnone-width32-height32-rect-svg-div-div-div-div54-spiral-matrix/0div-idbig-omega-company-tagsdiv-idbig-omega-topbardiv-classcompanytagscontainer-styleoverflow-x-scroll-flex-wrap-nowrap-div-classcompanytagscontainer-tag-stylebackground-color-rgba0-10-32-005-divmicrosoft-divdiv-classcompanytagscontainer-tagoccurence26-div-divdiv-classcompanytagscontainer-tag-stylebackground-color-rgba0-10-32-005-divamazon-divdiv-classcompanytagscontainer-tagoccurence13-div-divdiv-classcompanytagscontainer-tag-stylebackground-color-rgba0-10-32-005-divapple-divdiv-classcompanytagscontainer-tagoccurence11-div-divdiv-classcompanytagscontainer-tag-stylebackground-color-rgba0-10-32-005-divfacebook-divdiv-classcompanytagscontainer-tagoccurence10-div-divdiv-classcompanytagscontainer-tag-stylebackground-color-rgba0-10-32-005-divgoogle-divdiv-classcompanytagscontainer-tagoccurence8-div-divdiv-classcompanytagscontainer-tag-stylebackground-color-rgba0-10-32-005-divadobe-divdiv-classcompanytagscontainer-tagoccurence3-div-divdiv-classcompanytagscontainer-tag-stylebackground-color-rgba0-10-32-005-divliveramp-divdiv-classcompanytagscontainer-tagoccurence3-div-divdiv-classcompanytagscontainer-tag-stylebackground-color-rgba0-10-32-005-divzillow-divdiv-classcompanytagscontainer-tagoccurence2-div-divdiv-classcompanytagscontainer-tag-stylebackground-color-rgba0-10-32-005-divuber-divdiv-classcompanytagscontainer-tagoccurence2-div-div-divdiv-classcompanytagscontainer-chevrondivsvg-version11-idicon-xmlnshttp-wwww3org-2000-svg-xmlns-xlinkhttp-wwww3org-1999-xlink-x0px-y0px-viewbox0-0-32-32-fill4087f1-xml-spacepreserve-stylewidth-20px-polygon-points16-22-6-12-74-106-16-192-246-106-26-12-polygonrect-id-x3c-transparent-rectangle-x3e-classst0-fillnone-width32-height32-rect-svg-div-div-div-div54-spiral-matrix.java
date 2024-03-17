class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int N = matrix.length;
        int M = matrix[0].length;
        
        int total = N*M;
        int i = 0;
        int j = 0;
        int round = 0;
        while(total>0) {
            while(total>0 && j+round<M) {
                ans.add(matrix[i][j]);
                j++;
                total--;
            }
            j--;
            i++;
            while(total>0 && i+round<N) {
                ans.add(matrix[i][j]);
                i++;
                total--;
            }
            i--;
            j--;
            while(total>0 && j-round>-1) {
                ans.add(matrix[i][j]);
                j--;
                total--;
            }
            i--;
            j++;
            while(total>0 && i-round>0) {
                ans.add(matrix[i][j]);
                i--;
                total--;
            }
            i++;
            j++;
            round++;
        }
        return ans;
        
    }
}