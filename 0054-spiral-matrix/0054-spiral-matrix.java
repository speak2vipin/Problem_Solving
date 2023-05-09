class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
		int N = matrix.length;
        int M = matrix[0].length;
        int total = N*M;
        int x = 0;
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while(true) {
            while(count<total && j+x<M) {
                list.add(matrix[i][j]);
                j++;
                count++;
            }
            
            i++;
            j--;
            while(count<total && i+x<N) {
                list.add(matrix[i][j]);
                i++;
                count++;
            }
            j--;
            i--;
            while(count<total && j-x>-1) {
                list.add(matrix[i][j]);
                j--;
                count++;
            }
            i--;
            j++;
            while(count<total && i-x>0) {
                list.add(matrix[i][j]);
                i--;
                count++;
            }
            j++;
            i++;
            x++;
            if(count==total) {
            	break;
            }
        }
		return list;
	
        
    }
}