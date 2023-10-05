class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        
        Integer number1 = null;
        Integer count1 = 0;
        Integer number2 = null;
        Integer count2 = 0;
        
        for(int i=0; i<n; i++) {
            if(count1!=0 && nums[i]==number1) {
                count1++;
            } else if(count2!=0 && nums[i]==number2) {
                count2++;
            } else if(number1==null) {
                number1 = nums[i];
                count1++;
            } else if(number2==null) {
                number2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
                if(count1==0) {
                    number1 = null;
                }
                if(count2==0) {
                    number2 = null;
                }
            }
        }
        count1 = 0;
        count2 = 0;
        for(int num : nums) {
            if(number1!=null && num==number1) {
                count1++;
            }
            if(number2!=null && num==number2) {
                count2++;
            }
        }
        ArrayList<Integer> res= new ArrayList<>();
        if(count1>n/3) {
            res.add(number1);
        }
        if(count2>n/3) {
            res.add(number2);
        }
        return res;
    }
}