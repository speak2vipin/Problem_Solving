class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> resultSet =  new HashSet<String>();
        Set<String> sSet = new HashSet<String>();
        for(int i = 0; i+10<=s.length();i++) {
            if(!sSet.add(s.substring(i,i+10))) {
                resultSet.add(s.substring(i,i+10));
            }
        }
        
        return new ArrayList<>(resultSet);
    }
}