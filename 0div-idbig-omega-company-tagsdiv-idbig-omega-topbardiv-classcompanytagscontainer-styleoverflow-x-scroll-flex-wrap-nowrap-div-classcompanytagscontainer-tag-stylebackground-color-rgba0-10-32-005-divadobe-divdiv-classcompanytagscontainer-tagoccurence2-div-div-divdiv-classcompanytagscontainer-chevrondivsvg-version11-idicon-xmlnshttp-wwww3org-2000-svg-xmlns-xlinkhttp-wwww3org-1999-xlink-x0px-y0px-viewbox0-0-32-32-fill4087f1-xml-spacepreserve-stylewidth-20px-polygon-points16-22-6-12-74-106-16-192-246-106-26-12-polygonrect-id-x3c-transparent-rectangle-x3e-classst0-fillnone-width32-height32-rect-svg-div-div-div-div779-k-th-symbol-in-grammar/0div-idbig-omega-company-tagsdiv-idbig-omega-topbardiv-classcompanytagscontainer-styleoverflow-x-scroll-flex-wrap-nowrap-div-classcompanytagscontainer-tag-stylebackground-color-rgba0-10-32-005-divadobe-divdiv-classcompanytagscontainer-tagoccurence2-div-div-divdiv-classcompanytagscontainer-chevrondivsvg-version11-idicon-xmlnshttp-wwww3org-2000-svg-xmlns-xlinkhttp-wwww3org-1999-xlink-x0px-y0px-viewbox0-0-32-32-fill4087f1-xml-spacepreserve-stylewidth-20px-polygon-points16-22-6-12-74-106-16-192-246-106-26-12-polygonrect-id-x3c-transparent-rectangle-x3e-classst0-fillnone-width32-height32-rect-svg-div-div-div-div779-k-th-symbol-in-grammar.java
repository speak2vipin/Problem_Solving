class Solution {
    int flipCount = 0;
    
    public int kthGrammar(int n, int k) {
        flipping(n, k);
        return (flipCount%2)==0?0:1;
    }
    
    void flipping(int n, int k) {
        if(n==1) {
            return;
        }
        if(k%2==0) {
            flipCount++;
        }
        int parent = (k+1)/2;
        flipping(n-1, parent);
    }
}