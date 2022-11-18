class Solution {
    public boolean isUgly(int n) {
        if(n==0) {
            return false;
        }
        
        while(n!=1) {
            if(n%2==0) {
                n = n/2;
            } else {
                break;
            }
        }
        while(n!=1) {
            if(n%3==0) {
                n = n/3;
            } else {
                break;
            }
        }
        while(n!=1) {
            if(n%5==0) {
                n = n/5;
            } else {
                break;
            }
        }
         if(n==0 || n==1) {
            return true;
        }
        return false;
    }
}