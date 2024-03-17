class Solution {
     public int[][] constructProductMatrix(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];
        long prefixProduct = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result[i][j] = (int) (prefixProduct % (long) 12345);
                prefixProduct = (prefixProduct * grid[i][j]) % (long) 12345;
            }
        }
        long suffixProduct = 1;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                result[i][j] = (int) ((result[i][j] * suffixProduct) % (long) 12345);
                suffixProduct = (suffixProduct * grid[i][j]) % (long) 12345;
            }
        }
        return result;
    }

}