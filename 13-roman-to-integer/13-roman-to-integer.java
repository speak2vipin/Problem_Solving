class Solution {
    public int romanToInt(String s) {  
        
        Map<String, Integer> map = new HashMap <String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        String temp = "";
        String sec = "";
        if(s.length()==1) {
            return map.get(s);
        }
        int start = 0;
        int end = 2;
        int multi = 2;
        //String temp = null;
        int result = 0;
        int len = s.length();
        while(end<=len) {
            temp = s.substring(start, end);
            if(map.get(temp)==null) {
                result+=map.get(s.substring(start, start+1));
                start = start+1<len?start+1:len-1;
                end = end+1<=len?end+1:len;
            } else {
                result+=map.get(temp);
                start = start+2<len?start+2:start+1;
                end = end+2<=len?end+2:end+1;
            }     
        }
        return result;       
    }
}