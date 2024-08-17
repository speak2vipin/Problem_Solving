class Solution {
    public boolean lemonadeChange(int[] bills) {
        int i = 0;
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for(int j=0; j<bills.length; j++) {
            if(bills[j]==5) {
                five++;
            } else if(bills[j]==10) {
                if(five==0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if(five>0 && ten>0) {
                    five--;
                    ten--;
                } else if(five>=3) {
                    five -= 3;
                } else {
                    return false;
                }
                twenty++;
            }
        }
        return true;
    }
}