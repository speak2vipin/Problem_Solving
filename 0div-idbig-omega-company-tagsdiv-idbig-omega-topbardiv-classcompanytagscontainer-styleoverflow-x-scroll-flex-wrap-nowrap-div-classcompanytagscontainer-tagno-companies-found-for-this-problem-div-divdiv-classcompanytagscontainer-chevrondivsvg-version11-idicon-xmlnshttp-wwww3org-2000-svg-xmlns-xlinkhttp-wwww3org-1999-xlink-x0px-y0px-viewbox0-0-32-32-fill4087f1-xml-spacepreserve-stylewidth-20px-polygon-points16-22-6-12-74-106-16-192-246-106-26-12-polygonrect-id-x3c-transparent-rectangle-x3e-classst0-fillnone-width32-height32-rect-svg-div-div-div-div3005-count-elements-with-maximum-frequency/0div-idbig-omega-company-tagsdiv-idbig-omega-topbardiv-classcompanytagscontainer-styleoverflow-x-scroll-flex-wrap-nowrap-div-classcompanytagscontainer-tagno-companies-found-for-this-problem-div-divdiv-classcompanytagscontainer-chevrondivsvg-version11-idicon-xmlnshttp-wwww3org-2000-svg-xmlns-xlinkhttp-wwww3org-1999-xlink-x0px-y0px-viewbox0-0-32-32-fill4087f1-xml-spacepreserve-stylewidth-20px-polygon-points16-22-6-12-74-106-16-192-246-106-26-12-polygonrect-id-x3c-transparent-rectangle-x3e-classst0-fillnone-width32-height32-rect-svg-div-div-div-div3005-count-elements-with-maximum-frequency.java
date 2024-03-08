class Solution {
    public int maxFrequencyElements(int[] nums) {
        int freq[] = new int[101];
        for(int num : nums) {
            freq[num]++;
        }
        int max = 0;
        int count = 0;
        for(int f : freq) {
            if(f>max) {
                max = f;
                count = f;
            } else if(f==max) {
                count += f;
            }
        }
        return count;
    }
}