class Solution {
    // Logic:
        // U need to traverse all the elements 
        // Keep on count rounds. It will help u in traversing matrix elements
        // Take care of count<total condition in every while loop as there could be duplicacy of elements in ans list
                    
    public List<Integer> spiralOrder(int[][] matrix) {
        
		int N = matrix.length;
        int M = matrix[0].length;
        int total = N*M;
        int round = 0;
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while(true) {
            
            while(count<total && j+round<M) {
                list.add(matrix[i][j]);
                j++;
                count++;
            }
            i++;  
            j--;    // Takle care of it as it would go beyond M
            
            while(count<total && i+round<N) {
                list.add(matrix[i][j]);
                i++;
                count++;
            }
            j--;
            i--;    // Take care of it as it would go beyond N
            
            while(count<total && j-round>-1) {
                list.add(matrix[i][j]);
                j--;
                count++;
            }
            i--;
            j++;    // Take care of it as it would go beyond M
            
            while(count<total && i-round>0) {   // Take care of i-round >0 i.e. 
                                                // here we are not traversing for 0 index
                list.add(matrix[i][j]);
                i--;
                count++;
            }
            j++;
            i++;    // Take care of it as it would go beyond N
            
            round++;
            if(count==total) {
            	break;
            }
        }
		return list;
    }
}