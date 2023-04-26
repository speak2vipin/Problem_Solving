class Solution {
    public int addDigits(int num) {
        int temp = num;
        // Evaluating is num a single digit number
        while((num/10)!=0) {
            temp = 0;
            // Calculating sum of digits of num
            while(num!=0) {
                temp += num%10; 
                num = num/10;
            }
            num = temp;      
        }
        return num;
    }
}