class Solution {
    public int addDigits(int num) {
        int temp = num;
        while((num/10)!=0) {
            temp = 0;
            while(num!=0) {
                temp += num%10; 
                num = num/10;
            }
            num = temp;      
        }
        return num;
    }
}