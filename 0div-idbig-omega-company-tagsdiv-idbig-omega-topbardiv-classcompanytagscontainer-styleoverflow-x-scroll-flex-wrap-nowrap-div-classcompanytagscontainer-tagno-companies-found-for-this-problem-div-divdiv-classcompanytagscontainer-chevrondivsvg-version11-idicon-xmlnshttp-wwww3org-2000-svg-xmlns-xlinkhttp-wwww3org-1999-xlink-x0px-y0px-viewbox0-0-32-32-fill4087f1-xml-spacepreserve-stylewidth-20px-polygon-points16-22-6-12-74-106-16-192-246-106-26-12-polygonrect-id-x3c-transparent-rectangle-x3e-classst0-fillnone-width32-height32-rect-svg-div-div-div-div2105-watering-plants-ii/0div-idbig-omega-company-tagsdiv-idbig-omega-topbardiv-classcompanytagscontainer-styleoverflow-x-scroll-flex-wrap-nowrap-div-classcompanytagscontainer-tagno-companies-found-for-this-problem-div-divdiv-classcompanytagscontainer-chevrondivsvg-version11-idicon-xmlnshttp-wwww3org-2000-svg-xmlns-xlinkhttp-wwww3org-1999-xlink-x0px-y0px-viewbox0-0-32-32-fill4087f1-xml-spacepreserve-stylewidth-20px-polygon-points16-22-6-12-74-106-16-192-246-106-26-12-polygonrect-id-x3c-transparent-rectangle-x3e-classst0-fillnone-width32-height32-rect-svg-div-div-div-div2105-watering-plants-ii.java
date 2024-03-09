class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i = 0;
        int j = plants.length-1;
        int result = 0;
        int tempCapacityA = capacityA;
        int tempCapacityB = capacityB;
        
        while(i<=j) {
            if(i==j) {
                if(plants[i]>Math.max(tempCapacityA, tempCapacityB)) {
                   result++; 
                }
            } else {
                /*if(plants[i]<=tempCapacityA) {
                    tempCapacityA -= plants[i];
                } else {
                    result++;
                    tempCapacityA = capacityA;
                    tempCapacityA -= plants[i];

                }*/
                if(plants[i]>tempCapacityA) {
                    result++;
                    tempCapacityA = capacityA;
                }
                tempCapacityA -= plants[i];
                
                /*if(plants[j]<=tempCapacityB) {
                    tempCapacityB -= plants[j];
                } else {
                    result++;
                    tempCapacityB = capacityB;
                    tempCapacityB -= plants[j];
                }*/
                if(plants[j]>tempCapacityB) {
                    result++;
                    tempCapacityB = capacityB;
                }
                tempCapacityB -= plants[j];
            }
            i++;
            j--;
        }
        return result;
    }
}