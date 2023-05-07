class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int N = obstacles.length;
        int answers[] = new int[N];
        int lis[] = new int[N];
        int lisLength = 0;
        for(int i=0; i<N; i++) {
            int height = obstacles[i];
            int idx = binarySearch(lis, height, lisLength);
            if(idx == lisLength) {
                lisLength++;
            }
            lis[idx] = height;
            answers[i] = idx+1;
        }
        return answers;
    }
    
    int binarySearch(int A[], int x, int right) {
        if(right==0) {
            return 0;
        }
        int left = 0;
        while(left<right) {
            int mid = left + (right-left)/2;
            if(A[mid]<=x) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}