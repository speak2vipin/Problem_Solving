class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> reminderMap = new HashMap<>();
        int required = 0;
        for(int a : arr) {
            int reminder = (a%k+k)%k;
            if(reminder==0) {
                required = 0;
            } else {
                required = k-reminder;
            }
             
            if(reminderMap.get(required)!=null) {
                reminderMap.put(required, reminderMap.get(required)-1);
                if(reminderMap.get(required)==0) {
                    reminderMap.remove(required);
                }
            } else {
                reminderMap.put(reminder, reminderMap.getOrDefault(reminder, 0)+1);
            }
        }
        return reminderMap.size()==0;
    }
}