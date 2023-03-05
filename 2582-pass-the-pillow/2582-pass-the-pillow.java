class Solution {
    public int passThePillow(int n, int time) {
        int x = n-1;
        int spot = time%x;
        int turn = time/x;
        if(turn%2==0) {
            spot = spot+1;
        } else {
            spot = n-spot;
        }
        return spot;
    }
}