class Solution {

    private int fun(int i, int j, int[][] grid, int n, int m, int cnt) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == -1) {
            return 0;
        }

        if (grid[i][j] == 2) {
            return cnt == -1 ? 1 : 0;
        }

        int temp = grid[i][j];

        grid[i][j] = -1;

        int a = fun(i + 1, j, grid, n, m, cnt - 1);
        int b = fun(i, j + 1, grid, n, m, cnt - 1);
        int c = fun(i - 1, j, grid, n, m, cnt - 1);
        int d = fun(i, j - 1, grid, n, m, cnt - 1);
        grid[i][j] = temp;

        return a + b + c + d;
    }

    public int uniquePathsIII(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    cnt++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    return fun(i, j, grid, n, m, cnt);
                }
            }
        }

        return 0;
    }
}
