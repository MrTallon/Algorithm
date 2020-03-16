package dp;

/**
 * 最大岛屿
 * https://leetcode-cn.com/problems/max-area-of-island/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-03-15 15:41
 */
public class MaxAreaOfIsland_0695 {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max (dfs(grid, i, j), max);
                }
            }
        }
        return max;
    }
    int dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int count = 1;
        count += dfs(grid, i+1, j);
        count += dfs(grid, i-1, j);
        count += dfs(grid, i, j+1);
        count += dfs(grid, i, j-1);
        return count;
    }

}
