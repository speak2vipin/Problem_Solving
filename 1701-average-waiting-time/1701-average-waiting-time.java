class Solution {
    public double averageWaitingTime(int[][] customers) {
        double total = 0;
        int en = -1;
        int st = -1;
        for(int c[] : customers) {
            if(st==-1) {
                st = c[0];
            }
            if(st>=c[0]) {
                en = st + c[1];
                total += en - c[0];
            } else {
                total += c[1];
                en = c[0] + c[1];
            }
            st = en;
        }
        return ((double)(total))/customers.length;
    }
}