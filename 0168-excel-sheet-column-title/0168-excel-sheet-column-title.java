class Solution {
    public String convertToTitle(int columnNumber) {
        
        StringBuilder res = new StringBuilder();
        while(columnNumber>0) {
            int mod = (columnNumber-1)%26;      
            res.append((char)(65+mod));   
            columnNumber = (columnNumber-1)/26;
        }
        return res.reverse().toString();
    
    }
}