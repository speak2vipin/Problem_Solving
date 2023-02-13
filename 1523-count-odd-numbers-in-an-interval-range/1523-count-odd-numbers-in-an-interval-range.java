class Solution {
    public int countOdds(int low, int high) {
        int count = ((high-low)/2);
        boolean isOneOdd = (((low%2) != 0) || ((high%2) != 0));
        if(isOneOdd) {
            count = count + 1;
        } 
        return count;
    }
}