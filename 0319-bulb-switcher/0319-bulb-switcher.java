class Solution {
    public int bulbSwitch(int n) {
       /* int x = 1;
        int count = 0;
        while(x*x <= n) {
            count++;
            x++;
        }
        return count;
        */
        return (int)Math.sqrt(n);
    }
}