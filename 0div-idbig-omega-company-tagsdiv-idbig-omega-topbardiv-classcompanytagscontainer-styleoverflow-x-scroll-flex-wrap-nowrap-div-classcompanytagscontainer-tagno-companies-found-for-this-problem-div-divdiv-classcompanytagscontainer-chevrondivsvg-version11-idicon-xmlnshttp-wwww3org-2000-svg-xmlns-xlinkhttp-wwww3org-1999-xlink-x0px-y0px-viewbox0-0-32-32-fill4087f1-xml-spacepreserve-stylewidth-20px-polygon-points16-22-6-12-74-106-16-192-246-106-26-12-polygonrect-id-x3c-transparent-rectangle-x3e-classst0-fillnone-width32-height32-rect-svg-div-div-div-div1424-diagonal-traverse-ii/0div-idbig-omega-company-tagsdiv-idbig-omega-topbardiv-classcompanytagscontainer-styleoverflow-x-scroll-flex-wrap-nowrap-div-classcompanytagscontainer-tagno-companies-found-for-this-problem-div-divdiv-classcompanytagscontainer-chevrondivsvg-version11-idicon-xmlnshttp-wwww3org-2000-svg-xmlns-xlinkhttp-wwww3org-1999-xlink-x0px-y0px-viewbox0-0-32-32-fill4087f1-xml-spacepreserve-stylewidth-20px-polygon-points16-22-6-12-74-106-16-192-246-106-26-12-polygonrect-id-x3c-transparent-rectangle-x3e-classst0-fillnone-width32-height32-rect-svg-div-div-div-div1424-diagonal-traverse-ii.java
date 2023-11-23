class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size();
        List<Integer> ans = new ArrayList<>();
        /*int m = Integer.MIN_VALUE;
        for(int x=0; x<n; x++) {
            int j = x;
            int i = 0;
            m = Math.max(m, nums.get(x).size());
            while(j>-1) {
                if(nums.get(j).size()>i)
                    ans.add(nums.get(j).get(i));
                j--;
                i++;
            }
        }
        
        for(int y=1; y<m; y++) {
            int j = n-1;
            int i = y;
            while(j>-1) {
                if(nums.get(j).size()>i)
                    ans.add(nums.get(j).get(i));
                j--;
                i++;
            }
        }*/
        Queue<int[]> qe = new LinkedList<>();
        qe.offer(new int[]{0,0});
        while(!qe.isEmpty()) {
            int top[] = qe.poll();
            int i = top[0];
            int j = top[1];
            ans.add(nums.get(i).get(j));
            if(j==0 && i<n-1) {
                qe.offer(new int[]{i+1, j});
            }
            if(j+1<nums.get(i).size()) {
                qe.offer(new int[]{i, j+1});
            }
        }
        int res[] = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}