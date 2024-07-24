class Solution {
    public int[] frequencySort(int[] nums) {
        int a[][] = new int[201][2];
        for(int num : nums) {
            a[num+100][0]++;
            a[num+100][1] = num;
        }
        
        Arrays.sort(a, (x,y)->x[0]==y[0]?Integer.compare(y[1], x[1]):Integer.compare(x[0], y[0]));
        int res[] = new int[nums.length];
        int index = 0;
        for(int A[] : a) {
            int count = A[0];
            if(count!=0) {
                while(count-->0) {
                    res[index++] = A[1]; 
                }
            }
        }
        return res;
    }
}