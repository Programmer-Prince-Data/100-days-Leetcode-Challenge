class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i = 0, j = 0;
        boolean[][] seen = new boolean[m][n];
        seen[0][0] = true;
        while(true){
            int r = i, c = j;
            char ch = grid[i][j];
            if(ch == 'L') c--;
            else if(ch == 'R') c++;
            else if(ch == 'U') r--;
            else r++;
            if(r < 0 || c < 0 ||r >= m || c >= n|| seen[r][c]) break;

            seen[r][c] = true;
            i = r;
            j = c;
        }
        return new int[]{i, j};
    }
}