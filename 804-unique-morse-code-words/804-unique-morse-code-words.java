class Solution {
    
    String code[] = { ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",
    		".-.","...","-","..-","...-",".--","-..-","-.--","--.." };
    
	public int uniqueMorseRepresentations(String[] words) {
        
        Set<String>transformations = new HashSet<String>();
        for(String s : words) {
        	transformations.add(formCode(s));
        }
        return transformations.size();
    }
	
	String formCode(String s) {
		String result = "";
		for(int i=0; i<s.length();i++) {
			result+=code[s.charAt(i)-'a'];
		}
		return result;
	}
}