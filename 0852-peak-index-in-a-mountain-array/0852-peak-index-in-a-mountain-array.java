class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int st = 0;
        int en = arr.length-1;
        while(st<=en) {
            int mid = en - (en-st)/2;
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]) {
                return mid;
            } 
            if(arr[mid]>arr[mid+1]) {
                en = mid-1;
            } else {
                st = mid+1;
            }
        }
        return -1;
    }
}