package dp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * 找小岛
 *
 * @author YangBo
 * @date 2019/06/17
 */
public class NumIslands {

}

class DFSDemo {
    private boolean[][] visited;
    private int numRow;
    private int numCol;

    public int numIslands(char[][] grid) {
        // Validate input
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        // Initiation
        int total = 0;
        numRow = grid.length;
        numCol = grid[0].length;
        visited = new boolean[numRow][numCol];

        // Search for entry point
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ++total;
                    // Start DFS
                    dfs(grid, i, j);
                }
            }
        }
        return total;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= numRow || j < 0 || j >= numCol
                || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}


class BFSDemo {
    private boolean[][] visited;
    private int numRow;
    private int numCol;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int total = 0;
        numRow = grid.length;
        numCol = grid[0].length;
        visited = new boolean[numRow][numCol];

        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                if (isValid(grid, i, j)) {
                    ++total;
                    bfs(grid, i, j);
                }
            }
        }
        return total;
    }

    private void bfs(char[][] grid, int row, int col) {
        visited[row][col] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(row, col));
        Pair curIdx;

        while (!queue.isEmpty()) {
            curIdx = queue.poll();
            int i = curIdx.row;
            int j = curIdx.col;
            if (i > 0) {
                // TODO
            }
        }
    }

    private boolean isValid(char[][] grid, int row, int col) {
        return !visited[row][col] && grid[row][col] == '1';
    }

    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
