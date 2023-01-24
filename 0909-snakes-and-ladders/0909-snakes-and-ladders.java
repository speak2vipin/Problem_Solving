class Solution {
  
    public int snakesAndLadders(int[][] board) {
      
	        int N = board.length;
	        Map<Integer, Integer>map = new HashMap<Integer, Integer>();
	         Queue<Integer> qe = new LinkedList<Integer>();
	         map.put(1,0);
	         qe.offer(1);
	         while(!qe.isEmpty()) {
	             int p = qe.poll();
	             if(p==N*N) {
	                 return map.get(p);
	             }
	             for(int i=p+1; i<=Math.min(p+6, N*N); i++) {
	                 int next = i;
	                 int rowIndex = (next-1)/N;
	                 int colIndex = (next-1)%N;
	 	            int actualRowIndex = N-rowIndex-1;
	 	            int actualColIndex = -1;
	 	            if(rowIndex%2==0) {
	 	                actualColIndex = colIndex;
	 	            } else {
	 	                actualColIndex = N-1-colIndex;
	 	            }
	 	           // System.out.println(actualRowIndex+" "+actualColIndex);
	                 int ns = board[actualRowIndex][actualColIndex]==-1 ? i : board[actualRowIndex][actualColIndex];
	                 
	                 if(!map.containsKey(ns)) {
	                     map.put(ns, map.get(p)+1);
	                     qe.offer(ns);
	                 }
	             }
	         }
	         return -1;
	     
        
    }
}