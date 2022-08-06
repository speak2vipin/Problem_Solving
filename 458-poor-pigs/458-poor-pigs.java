class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        //Practice it
       int T = minutesToTest/minutesToDie;   //Trial count          
        return (int)Math.ceil(Math.log(buckets)/Math.log(T+1));
    }
}