//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static Map<Integer, ArrayList<Integer>> adj = null;
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        // code here
        adj = new HashMap<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(graph[i][j]==1) {
                    adj.computeIfAbsent(i, val->new ArrayList<Integer>()).add(j);
                }
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<N; i++) {
            ArrayList<Integer> output = new ArrayList<Integer>();
            for(int j=0; j<N; j++) {
                output.add(0);
            }
            
            int visit[] = new int[N];
            output.set(i, 1);
            visit[i] = 1;
            DFS(i, visit, output);
            ans.add(output);
        }
        return ans;
    }
    
    static void DFS(Integer source,
        int visit[], ArrayList<Integer> output) {
            
        if(adj.get(source)!=null) {
            ArrayList<Integer> neighbors = adj.getOrDefault(
                source, new ArrayList<Integer>());
            for(Integer neighbor : neighbors) {
                if(visit[neighbor]==0) {
                    visit[neighbor]=1;
                    output.set(neighbor, 1);
                    DFS(neighbor, visit, output);
                }
            }
        }
    }
}