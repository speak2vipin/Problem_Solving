class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        int remaining = 0;
        int ex = 0;
        while(numBottles>=numExchange) {
            ex = numBottles/numExchange;
            count += ex;
            ex += numBottles%numExchange;
            numBottles = ex;
        }
        return count;
    }
}