package Hot100.Backtracking;

public class WordSearch {
    int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)){
                    if (dfs(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int cur){
        //检查当前字符是否匹配
        if (board[i][j] != word.charAt(cur) || visited[i][j]) return false;
        //匹配成功,判断是否匹配完
        if (cur == word.length() - 1) return true;

        visited[i][j] = true;
        for (int[] direction : DIRECTIONS) {
            int nextX = i + direction[0];
            int nextY = j + direction[1];
            if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length) continue;
            if (visited[nextX][nextY]) continue;
            if (dfs(board, word, nextX, nextY, cur + 1)){
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
