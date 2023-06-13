class Solution {
    public int equalPairs(int[][] grid) {
       
        Map<String, Integer> mapRow = new HashMap<>();
        int n = grid.length;
        
        for(int i=0; i<n; i++) {
            StringBuilder keyRow = new StringBuilder();
            for(int j=0; j<n; j++) {
                keyRow.append(grid[i][j]).append("_");
            }
            mapRow.put(keyRow.toString(), mapRow.getOrDefault(keyRow.toString(), 0)+1);
        }
        
        int resRow = 0;
         for(int j=0; j<n; j++) {
            StringBuilder keyCol = new StringBuilder();
            for(int i=0; i<n; i++) {
                keyCol.append(grid[i][j]).append("_");
            }
            if(mapRow.get(keyCol.toString())!=null) {
                resRow+= mapRow.get(keyCol.toString());
            }
        }
        return resRow;  
    }
}