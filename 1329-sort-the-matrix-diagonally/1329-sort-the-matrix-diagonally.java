class Solution {
    public int[][] diagonalSort(int[][] a) {
	        int M = a.length;
	        int N = a[0].length;
	        for(int j=N-1;j>-1;j--) {
	            int i=0, k=j;
	            List<Integer> list = new ArrayList<Integer>();
	            while(i<M && k<N) {
	                list.add(a[i][k]);
	                i++;
	                k++;
	            }
	            Collections.sort(list);
	            i=0;
	            k=j;
	            int index = 0;
	            while(i<M && k<N && index<list.size()) {
	                a[i][k] = list.get(index);
	                i++;
	                k++;
	                index++;
	            }    
	        }
	        
	        for(int i=1;i<M;i++) {
	            int j=0, k=i;
	            List<Integer> list = new ArrayList<Integer>();
	            while(k<M && j<N) {
	                list.add(a[k][j]);
	                k++;
	                j++;
	            }
	            Collections.sort(list);
	            k=i;
	            j=0;
	            int index = 0;
	            while(k<M && j<N && index<list.size()) {
	                a[k][j] = list.get(index);
	                k++;
	                j++;
	                index++;
	            }    
	        }
	        return a;
	    
    }
}