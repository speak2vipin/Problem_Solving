class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        //int x1 = coordinate1.get(0)-'a';
        //int y1 = coordinate1.get(0)-'1';
        //int x2 = coordinate2.get(0)-'a';
        //int y2 = coordinate2.get(0)-'1';
        //Map<Character, Character> m = new HashMap<>();
        //m.put('a', '1');m.put('b', '2');m.put('c', '3');m.put('d', '4');
        //m.put('e', '5');m.put('f', '6');m.put('g', '7');m.put('h', '8');
        return ((coordinate1.charAt(0)-'a' + coordinate1.charAt(1)-'1'+ 
            coordinate2.charAt(0)-'a' + coordinate2.charAt(1)-'1'))%2==0;
    }
}