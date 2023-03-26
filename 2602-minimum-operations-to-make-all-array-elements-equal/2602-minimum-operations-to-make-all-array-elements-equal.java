class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        /*List<Long> ans = new ArrayList<>();
        for(int q : queries) {
            long count = 0;
            for(int num : nums) {
                count += Math.abs(num-q);
            }
            ans.add(count);
        }
        return ans;
        }*/
        
        Arrays.sort(nums);
		int n = nums.length;
		long prefix[] = new long[n];
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				prefix[0] = nums[i];
			} else {
				prefix[i] = prefix[i - 1] + nums[i];
			}
		}
		

		List<Long> ans = new ArrayList<>();
		for (int q : queries) {
			long count = 0;
			int index = minLargestNumIndex(nums, q);
			if(index==0) {
				count = prefix[n-1] - 1l*q*n;
			} else if(index==n) {
				count = 1l*q*n - prefix[n-1];
			} else {
				count = (1l*q*index) - prefix[index-1] + prefix[n-1] - prefix[index-1] - (1l * (n-index)*q);
			}
			
			
			ans.add(count);
		}
		return ans;
	}

	/*int minLargestNumIndex(int A[], int number) {
		int st = 0;
		int en = A.length - 1;
		int mid = 0;
		while (st < en) {
			mid = st + (en - st) / 2;
			if(A[mid]>number && (mid==0 || A[mid-1]<=number)){
				return mid;
			}
			if (A[mid] <= number) {
				st = mid+1;
			} else {
				en = mid-1;
			}
		}
		return en+1;
	}*/
    
    private int minLargestNumIndex(int[] nums, int key) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (key > nums[mid]) {
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
        return lo;
    }
    
}