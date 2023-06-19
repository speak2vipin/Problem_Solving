class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0;
        int altitudes = 0;
        for(int change : gain) {
            altitudes = altitudes + change;
            res = Math.max(res, altitudes);
        }
        return res;
    }
}