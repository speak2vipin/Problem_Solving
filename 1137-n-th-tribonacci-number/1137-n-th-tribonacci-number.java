class Solution {
    public int tribonacci(int n) {
      /* if(n<=1) {
            return n;
        } else if(n==2) {
            return 1;
        }
        return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
        */
         if(n<=1) {
            return n;
        } else if(n==2) {
            return 1;
        }
        int f[] = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 1;
        for(int i=3; i<n+1; i++) {
            f[i] = f[i-1]+f[i-2]+f[i-3];
        }
        return f[n];
    }
}