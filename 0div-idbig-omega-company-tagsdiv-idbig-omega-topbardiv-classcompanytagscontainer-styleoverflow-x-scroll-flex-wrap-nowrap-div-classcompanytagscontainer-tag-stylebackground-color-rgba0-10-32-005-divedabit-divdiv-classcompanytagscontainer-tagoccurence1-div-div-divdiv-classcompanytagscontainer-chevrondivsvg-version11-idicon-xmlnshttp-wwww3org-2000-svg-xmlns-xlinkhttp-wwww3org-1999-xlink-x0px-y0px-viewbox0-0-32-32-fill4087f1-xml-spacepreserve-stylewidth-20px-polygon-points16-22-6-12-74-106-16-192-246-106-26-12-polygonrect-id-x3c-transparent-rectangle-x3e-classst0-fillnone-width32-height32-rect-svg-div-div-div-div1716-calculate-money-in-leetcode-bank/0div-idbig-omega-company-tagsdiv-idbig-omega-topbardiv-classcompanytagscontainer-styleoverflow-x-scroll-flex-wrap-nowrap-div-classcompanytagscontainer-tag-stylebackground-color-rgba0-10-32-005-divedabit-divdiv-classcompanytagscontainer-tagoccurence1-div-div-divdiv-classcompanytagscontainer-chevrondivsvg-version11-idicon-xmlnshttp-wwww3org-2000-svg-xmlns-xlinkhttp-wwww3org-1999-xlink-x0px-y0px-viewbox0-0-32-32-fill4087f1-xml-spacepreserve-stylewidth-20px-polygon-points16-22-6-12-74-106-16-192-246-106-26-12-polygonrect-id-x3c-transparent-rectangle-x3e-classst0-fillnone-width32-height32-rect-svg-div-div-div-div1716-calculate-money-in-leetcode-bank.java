class Solution {
    public int totalMoney(int n) {
        int quotient = (n-1+7)/7;
        int count = 1;
        int answer = 0;
        int mod = ((n-1) % 7) + 1;
        while(count<quotient+1) {
            if(count==quotient) {
                answer += ((count + count + mod - 1)*mod)/2;
            } else {
                answer += ((count + count + 6)*7)/2;
            }
            
            count++;
        }
        return answer;
    }
}