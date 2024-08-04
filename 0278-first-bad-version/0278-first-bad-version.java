/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return firstBad(n);
    }
    
    int firstBad(int n) {
        int l = 1;
        int r = n;
        int bad = 0;
        while(l<=r) {
            int mid = r - (r-l)/2;
            if(isBadVersion(mid)) {
                bad = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return bad;
    }
}