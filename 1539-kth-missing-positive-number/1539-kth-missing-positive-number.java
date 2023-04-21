class Solution {
   /* public int findKthPositive(int[] arr, int k) {
        int temp = 1;
        int N = arr.length;
        for(int i=0; i<N; ) {
            if(k>0) {
                if(arr[i]!=temp) {
                    k--;
                } else {
                    i++;
                }
                temp++;
            } else {
                break;
            }
        }
                    
        while(k>0) {
            k--;
            temp++;
        } 
        return temp-1;        
    } */
    
    // Logic : A[mid] - mid - 1 < K then number will lie in right hand side 
    // or else left hand side
    public int findKthPositive(int[] A, int k) {
		int N = A.length;
		int left = 0;
		int right = N - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (A[mid] - mid - 1 < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left+k;
	}
}