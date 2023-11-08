class Solution {
    Map<int[], Boolean> visit = null;
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int dx = Math.abs(sx-fx);
        int dy = Math.abs(sy-fy);
        // If t=1 and cell is same as initial cell then in 1 step it is feasible to reach at the same cell
        if(dx==0 && dy==0 && t==1) {
            return false;
        }
        // Step is greater than max then is's possible or else it is not
        return t>=Math.max(dx,dy);
    }
}