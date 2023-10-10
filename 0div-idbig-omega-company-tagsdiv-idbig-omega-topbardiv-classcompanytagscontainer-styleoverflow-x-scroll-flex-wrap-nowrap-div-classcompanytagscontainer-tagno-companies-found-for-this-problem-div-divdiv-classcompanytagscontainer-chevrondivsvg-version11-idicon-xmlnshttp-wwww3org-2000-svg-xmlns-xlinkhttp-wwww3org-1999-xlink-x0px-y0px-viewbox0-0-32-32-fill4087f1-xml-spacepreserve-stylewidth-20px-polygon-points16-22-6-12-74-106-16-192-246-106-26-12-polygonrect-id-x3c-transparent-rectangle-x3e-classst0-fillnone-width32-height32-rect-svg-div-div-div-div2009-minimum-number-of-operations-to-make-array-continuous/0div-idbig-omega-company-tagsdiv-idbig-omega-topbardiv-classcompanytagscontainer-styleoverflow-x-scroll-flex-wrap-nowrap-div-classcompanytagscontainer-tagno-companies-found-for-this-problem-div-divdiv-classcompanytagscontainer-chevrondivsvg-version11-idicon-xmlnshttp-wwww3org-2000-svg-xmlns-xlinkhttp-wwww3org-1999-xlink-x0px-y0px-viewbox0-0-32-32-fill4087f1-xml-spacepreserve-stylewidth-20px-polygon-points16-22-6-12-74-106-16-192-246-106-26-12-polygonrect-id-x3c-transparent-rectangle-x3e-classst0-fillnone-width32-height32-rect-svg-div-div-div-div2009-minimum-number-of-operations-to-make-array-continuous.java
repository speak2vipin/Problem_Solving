class Solution {
    public int minOperations(int[] nums) {
            int n = nums.length;
            int ans = n;
            
            HashSet<Integer> unique = new HashSet<>();
            for (int num : nums) {
                unique.add(num);
            }
            
            int[] newNums = new int[unique.size()];
            int index = 0;
            
            for (int num : unique) {
                newNums[index++] = num;
            }
                
            Arrays.sort(newNums);
            //int N = newNums.length;
            int left = newNums[0];
            int right = left + n - 1;
            int j = 0;
            while(j<newNums.length && newNums[j]<=right) {
                j++;
            }
            ans = j;
            
            for (int i = 1; i < newNums.length; i++) {
                left = newNums[i];
                right = left + n - 1;
                while(j<newNums.length && newNums[j]<=right) {
                	j++;
                }
                ans = Math.max(ans, j-i);
            }
            
            return n-ans;
        }
    
    
}