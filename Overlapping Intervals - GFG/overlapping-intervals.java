//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here // Code here
        int start = -1;
        int end = -1;
        int n = Intervals.length;
        Arrays.sort(Intervals, (x,y)->x[0]-y[0]);
        List<int[]>ans = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(start==-1 && end==-1) {
                start = Intervals[i][0];
                end = Intervals[i][1];
            } else if(isOverlapping(Intervals[i], start, end)) {
                start = Math.min(Intervals[i][0], start);
                end = Math.max(Intervals[i][1], end);
            } else {
                ans.add(new int[]{start, end});
                start = Intervals[i][0];
                end = Intervals[i][1];
            }
        }
        if(start!=-1 && end!=-1) {
            ans.add(new int[]{start, end});
        }
        int size = ans.size();
        int response[][] = new int[size][2];
        for(int i=0; i<size; i++) {
            response[i] = new int[]{ans.get(i)[0], ans.get(i)[1]};
        }
        return response;
    }
    
    boolean isOverlapping(int x[], int start, int end) {
        return Math.min(x[1], end) - Math.max(x[0], start) >= 0;
    }
}