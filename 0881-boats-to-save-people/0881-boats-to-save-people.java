class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        
        int temp[] = new int[limit+1];
        for(int weight : people) {
            temp[weight] = temp[weight]+1;
        }
        int count = 0;
        int tempWeight = 0;
        int tempLimit = 0;
        int index = limit;
        while(index>0) {
            tempLimit = limit;
            tempWeight = index;
            if(temp[tempWeight]<=0) {
                index--;
            } else {
                count++;
                int noOfPeople = 0;
                while(tempWeight>0 && tempLimit > 0 && noOfPeople<2) {
                    if(temp[tempWeight] > 0) {
                        temp[tempWeight]--;
                        tempLimit = tempLimit -tempWeight;
                        tempWeight = tempLimit;
                        noOfPeople++;
                    } else {
                        tempWeight--;
                    }
                }
            }
            
        }
        return count;
    
    
    }
}