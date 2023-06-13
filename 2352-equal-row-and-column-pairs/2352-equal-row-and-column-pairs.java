class Solution {
    public int equalPairs(int[][] grid) {
       
        Map<String, Integer> mapRow = new HashMap<>();
        Map<String, Integer> mapCol = new HashMap<>();
        int n = grid.length;
        
        for(int i=0; i<n; i++) {
            StringBuilder keyRow = new StringBuilder();
            StringBuilder keyCol = new StringBuilder();
            for(int j=0; j<n; j++) {
                keyRow.append(grid[i][j]).append("_");
                keyCol.append(grid[j][i]).append("_");
            }
            mapRow.put(keyRow.toString(), mapRow.getOrDefault(keyRow.toString(), 0)+1);
            //mapCol.put(keyCol.toString(), mapCol.getOrDefault(keyCol.toString(), 0)+1);
        }
        
        int resRow = 0;
        int resCol = 0;
         for(int i=0; i<n; i++) {
            StringBuilder keyRow = new StringBuilder();
            StringBuilder keyCol = new StringBuilder();
            for(int j=0; j<n; j++) {
                keyRow.append(grid[i][j]).append("_");
                keyCol.append(grid[j][i]).append("_");
            }
            if(mapRow.get(keyCol.toString())!=null) {
                resRow+= mapRow.get(keyCol.toString());
            }
            if(mapCol.get(keyRow.toString())!=null) {
            	resCol+= mapCol.get(keyRow.toString());
            }
        }
        return Math.max(resRow, resCol);
        
    
        
    }
}