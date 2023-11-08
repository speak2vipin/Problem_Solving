class Solution {
    Map<int[], Boolean> visit = null;
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int dx = Math.abs(sx-fx);
        int dy = Math.abs(sy-fy);
        if(dx==0 && dy==0 && t==1) {
            return false;
        }
        return t>=Math.max(dx,dy);
    }
}