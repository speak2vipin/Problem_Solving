class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int ans[] = new int[2];
        HashSet<Integer> numbers = new HashSet<>();
        int i = 0;
        for(int num : nums) {
            if(!numbers.add(num)) {
                ans[i++] = num;
            }
        }
        return ans;
    }
}