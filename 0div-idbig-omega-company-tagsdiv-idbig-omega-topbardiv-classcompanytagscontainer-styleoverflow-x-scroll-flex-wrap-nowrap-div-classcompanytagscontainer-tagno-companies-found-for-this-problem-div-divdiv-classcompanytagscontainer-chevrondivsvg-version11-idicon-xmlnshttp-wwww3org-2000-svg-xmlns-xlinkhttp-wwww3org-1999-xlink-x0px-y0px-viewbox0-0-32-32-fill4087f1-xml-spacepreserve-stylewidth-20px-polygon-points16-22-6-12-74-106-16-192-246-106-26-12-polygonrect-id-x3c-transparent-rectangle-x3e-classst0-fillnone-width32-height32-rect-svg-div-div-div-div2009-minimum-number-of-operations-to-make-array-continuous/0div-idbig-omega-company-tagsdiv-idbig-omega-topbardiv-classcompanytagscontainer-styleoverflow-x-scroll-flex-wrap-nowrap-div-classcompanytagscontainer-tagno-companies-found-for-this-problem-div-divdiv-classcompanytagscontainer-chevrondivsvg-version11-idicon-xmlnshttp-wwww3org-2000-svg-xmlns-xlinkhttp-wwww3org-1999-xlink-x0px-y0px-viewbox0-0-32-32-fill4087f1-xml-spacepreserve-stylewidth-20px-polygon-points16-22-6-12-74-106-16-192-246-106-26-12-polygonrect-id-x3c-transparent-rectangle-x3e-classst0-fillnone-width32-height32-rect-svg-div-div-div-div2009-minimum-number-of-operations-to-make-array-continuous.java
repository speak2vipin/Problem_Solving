class Solution {
    public int minOperations(int[] nums) {
            
            int n = nums.length;
            
            // Find unique elements in Array
            HashSet<Integer> unique = new HashSet<>();
            for (int num : nums) {
                unique.add(num);
            }
            
            int[] newNums = new int[unique.size()];
            int index = 0;
            // Set unique elements to new  array
            for (int num : unique) {
                newNums[index++] = num;
            }
            // Sort newly created Array    
            Arrays.sort(newNums);
            // Considering the left hand side elements as the starting point of every window
            int left = newNums[0];
            // Right boundary 
            int right = left + n - 1;
        
            int j = 0;
            // Finding the length of maximum window 
            // having elements fron Left to Right
            
            while(j<newNums.length && newNums[j]<=right) {
                j++;
            }
        
            int ans = j;
            
            for (int i = 1; i < newNums.length; i++) {
                left = newNums[i];
                right = left + n - 1;
                // Recalculating the maximum window size
                while(j<newNums.length && newNums[j]<=right) {
                	j++;
                }
                ans = Math.max(ans, j-i);
            }
            // Rest of the elements
            return n-ans;
        }
    
    
}