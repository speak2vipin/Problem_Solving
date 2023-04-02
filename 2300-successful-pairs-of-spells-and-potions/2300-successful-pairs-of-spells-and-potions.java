class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int N = spells.length;
        int M = potions.length;
        
        int ans[] = new int[N];
        
        int spellIndex[][] = new int[N][2];
        for(int i=0; i<N; i++) {
            spellIndex[i] = new int[] {spells[i], i};
        }
        
        Arrays.sort(potions);
        Arrays.sort(spellIndex, (a,b) -> (Integer.compare(a[0], b[0])));
        
        int portionIndex = M-1;
        int count = 0;
        for(int temp[] : spellIndex) {
            int spell = temp[0];
            int index = temp[1];
            while(portionIndex >= 0 && 
                  ((1l*potions[portionIndex]) * spell) >= success)             {
                portionIndex--;
            }
            
            ans[index] = M - 1 - portionIndex;
        }
        
        return ans;
    }
}