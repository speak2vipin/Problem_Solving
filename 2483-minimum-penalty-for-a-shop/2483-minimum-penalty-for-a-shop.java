class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int countPenalty = 0;
        for(int i=0;i<n; i++) {
            if(customers.charAt(i)=='Y') {
                countPenalty++;
            }
        }
        int res = countPenalty;
        int index = 0;
        for(int i=0; i<n; i++) {
            if(customers.charAt(i)=='Y') {
                res--;
            } else {
                res++;
            }
            if(res<countPenalty) {
                index = i+1;
                countPenalty = res;
            }
        }
        return index;        
    }
}