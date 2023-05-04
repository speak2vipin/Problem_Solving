class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
          
        int freq[] = new int[101];
        int N = nums.length;
        int len = N - k + 1;
        int ans[] = new int[len];
        
        for(int i=0; i<k; i++) {
            freq[nums[i]+50]++;
        }
        int index =0; //[1, -1, -3, -2, 3]

        int count = 0;
        for(int i=0; i<101; i++) {
            count += freq[i];
            if(count>=x) {
                ans[index++] = i-50<0 ? i-50 : 0;
                break;
            }
        }
        for(int i=k; i<N; i++) {
            freq[nums[i-k]+50]--;
            freq[nums[i]+50]++;
            count = 0;
            for(int j=0; j<101; j++) {
                count += freq[j];
                if(count>=x) {
                    ans[index++] = j-50<0 ? j-50 : 0;
                    break;
                }
            }
        }
        
        return ans;
     
       
    }
}