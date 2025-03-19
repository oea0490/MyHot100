package Hot100.Graph;

public class NumberOfIslands {
    final int [][] DIRECTION = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        boolean [][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, boolean [][] visited, int i, int j){
        visited[i][j] = true;
        int row = grid.length;
        int col = grid[0].length;
        for (int[] direction : DIRECTION) {
            int nextX = i + direction[0];
            int nextY = j + direction[1];
            if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited[nextX][nextY] || grid[nextX][nextY] == '0'){
                continue;
            }
            dfs(grid, visited, nextX, nextY);
        }
        return;
    }
}
