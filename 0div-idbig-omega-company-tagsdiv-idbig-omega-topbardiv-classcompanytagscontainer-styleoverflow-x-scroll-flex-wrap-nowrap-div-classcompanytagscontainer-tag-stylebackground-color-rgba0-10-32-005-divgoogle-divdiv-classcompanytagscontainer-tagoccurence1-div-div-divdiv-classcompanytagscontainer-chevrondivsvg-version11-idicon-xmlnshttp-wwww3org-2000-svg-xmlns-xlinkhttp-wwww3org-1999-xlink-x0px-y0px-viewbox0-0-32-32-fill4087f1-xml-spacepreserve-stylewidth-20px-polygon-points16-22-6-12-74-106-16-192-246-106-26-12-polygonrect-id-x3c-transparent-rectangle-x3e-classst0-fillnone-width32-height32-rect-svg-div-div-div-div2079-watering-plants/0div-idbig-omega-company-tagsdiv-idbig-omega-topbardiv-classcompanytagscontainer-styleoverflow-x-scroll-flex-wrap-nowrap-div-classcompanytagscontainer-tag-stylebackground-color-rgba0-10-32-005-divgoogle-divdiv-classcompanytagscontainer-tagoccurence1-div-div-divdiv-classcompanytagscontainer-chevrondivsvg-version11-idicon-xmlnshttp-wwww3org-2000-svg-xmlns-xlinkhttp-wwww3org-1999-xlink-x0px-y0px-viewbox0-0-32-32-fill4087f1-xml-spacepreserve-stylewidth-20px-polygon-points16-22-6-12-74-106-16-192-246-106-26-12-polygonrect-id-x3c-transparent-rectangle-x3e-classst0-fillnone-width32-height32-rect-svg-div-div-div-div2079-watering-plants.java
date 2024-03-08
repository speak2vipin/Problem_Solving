class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int i = 0;
        int n = plants.length;
        int effort = 0;
        int temp = capacity;
        
        while(i<n) {
            if(plants[i]<=temp) {
                
            } else {
                temp = capacity;
                effort += 2*i;
            }
            temp -= plants[i];
            effort++;
            i++;
        }
        return effort;
        
    }
}