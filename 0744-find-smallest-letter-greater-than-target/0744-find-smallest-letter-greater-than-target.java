class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int st = 0;
        int en = letters.length-1;
        char ans = letters[0];
        while(st<=en) {
            int mid = (st + en)/2;
            if(letters[mid]>target) {
                ans = letters[mid];
                en = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }
}