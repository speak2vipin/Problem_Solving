class Solution {
    public int countPairs(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(compare(nums[i]+"", nums[j]+"")) {
                    count++;
                }
            }
        }
        return count;
    }
    
    boolean compare(String s, String t) {
        while(s.length()<t.length()) {
            s = '0'+s;
        }
        while(t.length()<s.length()) {
            t = '0'+t;
        }
        int k = 0;
        int index[] = new int[2];
        for(int i=0; i<t.length(); i++) {
            if(s.charAt(i)!=t.charAt(i)) {
                index[k++] = i;
            }
            if(k==2) {
                break;
            }
        }
        if(k==2) {
            char sChar[] = s.toCharArray();
            char temp = sChar[index[0]];
            sChar[index[0]] = sChar[index[1]];
            sChar[index[1]] = temp;
            s = new String(sChar);
        }
        return t.equals(s);
    }
}