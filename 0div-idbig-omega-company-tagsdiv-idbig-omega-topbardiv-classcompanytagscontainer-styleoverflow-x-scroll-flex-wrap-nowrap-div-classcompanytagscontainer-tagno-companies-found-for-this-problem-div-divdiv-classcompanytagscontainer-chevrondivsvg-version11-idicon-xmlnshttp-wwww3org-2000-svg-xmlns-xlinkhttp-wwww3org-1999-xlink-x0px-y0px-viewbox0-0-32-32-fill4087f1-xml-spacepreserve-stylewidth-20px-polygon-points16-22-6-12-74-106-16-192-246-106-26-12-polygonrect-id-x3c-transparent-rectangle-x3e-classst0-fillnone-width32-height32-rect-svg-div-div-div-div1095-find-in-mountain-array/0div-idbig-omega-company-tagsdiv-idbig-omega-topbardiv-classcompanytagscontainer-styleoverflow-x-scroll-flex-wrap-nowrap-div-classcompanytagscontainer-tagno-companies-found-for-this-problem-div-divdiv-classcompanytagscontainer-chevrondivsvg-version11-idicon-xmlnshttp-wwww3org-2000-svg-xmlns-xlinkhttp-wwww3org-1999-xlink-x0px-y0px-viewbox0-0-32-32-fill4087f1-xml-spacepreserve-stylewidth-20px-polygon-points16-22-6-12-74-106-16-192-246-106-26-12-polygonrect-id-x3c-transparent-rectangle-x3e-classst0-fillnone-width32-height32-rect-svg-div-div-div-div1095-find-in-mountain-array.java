/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peak = getPeak(mountainArr, 0, n-1);
        int left = binarySearchInIcreasingArray(mountainArr, 0, peak, target);
        if(left==-1) {
            int right = binarySearchInDecreasingArray(mountainArr, peak+1, n-1, target);
            return right;
        }
        return left;
    }
    int getPeak(MountainArray mountainArr, int st, int en) {
        int n = mountainArr.length();
        while(st<=en) {
            int mid = en - (en-st)/2;
            int val = mountainArr.get(mid);
            if(mid==0 || mid==n-1) {
                return mid;
            }
            int prev = mountainArr.get(mid-1);
            int next = mountainArr.get(mid+1);
            if(val>prev && val>next) {
                return mid;
            }
            if(val>prev && val<next) {
                st = mid + 1;
            } else {
                en = mid - 1;
            }
        }
        return -1;
    }
    
    int binarySearchInIcreasingArray(MountainArray mountainArr, int st, int en, int target) {
        while(st<=en) {
            int mid = (en+st)/2;
            int val = mountainArr.get(mid);
            if(val==target) {
                return mid;
            }
            if(val>target) {
                en = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return -1;
    }
    int binarySearchInDecreasingArray(MountainArray mountainArr, int st, int en, int target) {
        while(st<=en) {
            int mid = (en+st)/2;
            int val = mountainArr.get(mid);
            if(val==target) {
                return mid;
            }
            if(val>target) {
                st = mid + 1;
            } else {
                en = mid - 1;
            }
        }
        return -1;
    }
}