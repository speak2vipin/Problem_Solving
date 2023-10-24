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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        // code here
        return mincuts(str);
    }
    
    /*static int partition(String str, int st, int en) {
        if(st>=en || isPalindrome(str.substring(st, en+1))) {
            return 0;
        }
        int minPartitions = Integer.MAX_VALUE;
        int cuts = 0;
        for(int i=st; i<en; i++) {
            cuts = partition(str, st, i) + partition(str, i+1, en) + 1;
            minPartitions = Math.min(minPartitions, cuts);
        }
        return minPartitions;
    }
    static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }*/
    
    static boolean generatePalindrome(String s, boolean[][] pal) {
    	
        int n = s.length();
        for(int i=0; i<n; i++) {
        	pal[i][i] = true;
        }
        for(int len = 2; len<=n; len++) {
        	for(int i=0; i<=n-len; i++) {
        		int j = i + len -1;
        		if(s.charAt(i)==s.charAt(j) && (len==2 || pal[i+1][j-1])) {
        			pal[i][j] = true;
        		}
        	}
        }
        return true;
    }
    
    static int mincuts(String s) {
    	if(s==null || s.length()==0) {
    		return 0;
    	}
    	int n = s.length();
    	boolean pal[][] = new boolean[n][n];
    	generatePalindrome(s, pal);
    	int minCutDp[] = new int[n];
    	Arrays.fill(minCutDp, Integer.MAX_VALUE);
    	minCutDp[0] = 0;
    	for(int i=1; i<n; i++) {
    		if(pal[0][i]) {
    			minCutDp[i] = 0;
    		} else {
    			for(int j=i; j>=1; j--) {
    				if(pal[j][i]) {
    					if(minCutDp[j-1] + 1 < minCutDp[i]) {
    						minCutDp[i] = minCutDp[j-1] + 1;
    					}
    				}
    			}
    		}
    	}
    	return minCutDp[n-1];
    }
}