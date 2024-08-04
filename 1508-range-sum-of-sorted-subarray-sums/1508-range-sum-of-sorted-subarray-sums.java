class Solution {
    public int rangeSumBruteforce(int[] nums, int n, int left, int right) {
        int mod = 1000_000_007;
        List<Long> sumList = new ArrayList<>();
        for(int i=1; i<n+1; i++) {
            long sum = 0l;
            for(int j=i; j<=n; j++) {
                sum = (sum + nums[j-1])%mod;
                sumList.add(sum);
            }
        }
        
        Collections.sort(sumList, (x,y)->Long.compare(x, y));
        long res = 0;
        for(int i=left-1; i<right; i++) {
            res = (res + sumList.get(i))%mod;
        }
        return (int)res;
    }
    
    
    public int rangeSum(int[] nums, int n, int left, int right) {
        int sum = 0;
        int mod = 1000_000_007;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->Integer.compare(x[0], y[0]));
        for(int i=0; i<n; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int i = 1;
        while(i<=right) {
            int top[] = pq.poll();
            if(i>=left) {
                sum = (sum +top[0])%mod;
            }
            //System.out.println(sum);
            if(top[1]<n-1)
                pq.offer(new int[]{top[0] + nums[top[1]+1], top[1]+1});
             i++;
        }
        return sum;
    }
}