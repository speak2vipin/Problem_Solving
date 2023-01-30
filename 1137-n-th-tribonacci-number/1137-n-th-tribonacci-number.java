class Solution { 
    
    public int tribonacci(int n) {
      /* if(n<=1) {
            return n;
        } else if(n==2) {
            return 1;
        }
        return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
        */
            
    
        int f[] = new int[n+1];
        if(n<=1) 
            return n;
        else if(n==2)
            return 1;
        
        f[0] = 0;
        f[1] = 1;
        f[2] = 1;
       
        return helper(n, f);
    }
    
    int helper(int n, int f[]) {
        if(n==0 || f[n]>0) 
            return f[n];
        
        f[n-1] = helper(n-1, f);
        f[n-2] = helper(n-2, f);
        f[n-3] = helper(n-3, f);
            
        return f[n-1]+f[n-2]+f[n-3];
    }
}