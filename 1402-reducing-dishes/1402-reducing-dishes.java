class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int N = satisfaction.length;
        int maxSatisfaction = 0;
        int tempSatisfaction = 0;
        for(int i=N-1; i>=0; i--) {
            if(tempSatisfaction + satisfaction[i] >= 0) {
                tempSatisfaction += satisfaction[i];
                maxSatisfaction += tempSatisfaction;
            }
        }
        return maxSatisfaction;
    }
}