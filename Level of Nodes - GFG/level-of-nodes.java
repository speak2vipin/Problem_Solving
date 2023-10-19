//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // code here
        Queue<Integer> qe = new LinkedList<>();
        int visit[] = new int[V];
        qe.offer(0);
        visit[0] = 1;
        int level = 0;
        while(!qe.isEmpty()) {
            int size = qe.size();
            for(int i=0; i<size; i++) {
                int top = qe.poll();
                if(top==X) {
                    return level;
                }
                ArrayList<Integer> neighbors = adj.get(top);
                if(neighbors!=null) {
                    for(Integer neighbor : neighbors) {
                        if(visit[neighbor]==0) {
                            visit[neighbor]=1;
                            qe.offer(neighbor);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}