class Solution {
    public int minNumberOperations(int[] target) {
        int count = target[0];
        for(int i=1; i<target.length; i++) {
            count += Math.max(target[i] - target[i-1], 0);
        }
        return count;
    }
}