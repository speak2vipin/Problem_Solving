class Solution {
    public String minimumString(String a, String b, String c) {
        List<String> list = new ArrayList<>();
        String s1 = getMergedThree(a,b,c);
        String s2 = getMergedThree(a,c,b);
        
        String s3 = getMergedThree(b,a,c);
        String s4 = getMergedThree(b,c,a);
        
        String s5 = getMergedThree(c,a,b);
        String s6 = getMergedThree(c,b,a);
        
        list.add(s1); list.add(s2); list.add(s3); 
        list.add(s4); list.add(s5); list.add(s6);
        
        String res = list.get(0);
        
        for(int i=1; i<list.size(); i++) {
            if(res.length()<list.get(i).length()) {
                continue;
            }
            if(res.length()>list.get(i).length()) {
                res = list.get(i);
                continue;
            }
            if(list.get(i).compareTo(res)<0) {
                res = list.get(i);
            }
        }
        
        return res;
    }
    
    String getMergedThree(String s1, String s2, String s3) {
        String s1s2 = getMerged(s1, s2);
        return getMerged(s1s2, s3);
    }
    
    String getMerged(String s1, String s2) {
        if(s1.contains(s2)) {
            return s1;
        }
        int l1 = s1.length();
        int l2 = s2.length();
        int min = Math.min(l1, l2);
        for(int i=min; i>0; i--) {
            if(s1.substring(l1-i).contains(s2.substring(0, i))){
                s1 = s1 + s2.substring(i);
                return s1;
            }
        }
        return s1+s2;
    }
}