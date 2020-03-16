package dp;

/**
 * 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-03-15 16:06
 */
public class NumIslands_0200 {

    private boolean[][] visited;
    private int numRow;
    private int numCol;

    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        numCol = grid.length;
        if (numCol < 1) {
            return 0;
        }
        numRow = grid[0].length;
        int max = 0;
        visited = new boolean[numCol][numRow];
        for (int i = 0; i < numCol; i++) {
            for (int j = 0; j < numRow; j++) {
                if ('1' == grid[i][j]) {
                    max++;
                    dfs(grid, i, j);
                }
            }
        }
        return max;
    }

    void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= numCol || j < 0 || j >= numRow || '0' == grid[i][j] || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
