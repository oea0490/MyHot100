package Hot100.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
    List<List<String>> ans;
    List<String> path;
    Set<Integer> cols;
    Set<Integer> diag1s;
    Set<Integer> diag2s;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        cols = new HashSet<>();
        diag1s = new HashSet<>();
        diag2s = new HashSet<>();
        // 定义queens[i]表示第i行的皇后所在的列下标
        int[] queens = new int[n];
        dfs(queens, 0);
        return ans;
    }

    public void dfs(int[] queens, int row) {
        if (row == queens.length) {
            addAns(queens);
            return;
        }

        for (int col = 0; col < queens.length; col++) {
            int diag1 = row - col;
            int diag2 = row + col;
            if (cols.contains(col) || diag1s.contains(diag1) || diag2s.contains(diag2)) continue;
            //选择这一步
            queens[row] = col;
            cols.add(col);
            diag1s.add(diag1);
            diag2s.add(diag2);
            //搜索下一步
            dfs(queens, row + 1);
            //恢复现场
            queens[row] = 0;
            cols.remove(col);
            diag1s.remove(diag1);
            diag2s.remove(diag2);
        }
    }

    public void addAns(int[] queens) {
        path = new ArrayList<>();
        for (int row : queens){
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < queens.length; col++){
                if (col == row){
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            path.add(sb.toString());
        }
        ans.add(new ArrayList<>(path));
    }
}
