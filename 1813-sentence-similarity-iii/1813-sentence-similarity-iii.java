class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.equals(sentence2)) {
            return true;
        }
        
        String [] s1 = sentence1.split(" ");
        String [] s2 = sentence2.split(" ");
        
        Deque<String> qe1 = new ArrayDeque<>();
        Deque<String> qe2 = new ArrayDeque<>();
        
        for(String s : s1) {
            qe1.offer(s);
        }
        
        for(String s : s2) {
            qe2.offer(s);
        }
        
        while(!qe1.isEmpty() 
              && !qe2.isEmpty() 
              && qe1.peekFirst().equals(qe2.peekFirst())) {
            qe1.pollFirst();
            qe2.pollFirst();
        }
        
        while(!qe1.isEmpty() 
              && !qe2.isEmpty() 
              && qe1.peekLast().equals(qe2.peekLast())) {
            qe1.pollLast();
            qe2.pollLast();
        }
        
        return qe1.isEmpty() || qe2.isEmpty();
        
 
    }
}