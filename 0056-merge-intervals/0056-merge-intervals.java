class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> ((a[0]-b[0]==0) ? (a[1]-b[1]): (a[0]-b[0])));
        int N = intervals.length;
        List<int[]>ans = new ArrayList<int[]>();
        for(int i=0; i<N; i++) {
            int interval1[] = intervals[i];
            while(i<N && isOverlap(interval1, intervals[i]))  {
                interval1 = mergeIntervals(interval1 , intervals[i]);
                i++;
            }
            ans.add(interval1);
            i--;
        }
        return ans.toArray(new int[ans.size()][2]); 
    }
    
    boolean isOverlap(int a[], int b[]) {
        return (Math.min(b[1], a[1]) - Math.max(b[0], a[0])) >= 0;
    }
    
    int[] mergeIntervals(int a[], int b[]) {
        int x[] = { Math.min(a[0], b[0]), Math.max(a[1], b[1])};
        return x;
    } 
}