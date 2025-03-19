package Hot100.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        boolean[][] visited = new boolean[row][col];
        int direction = 0;
        int x = 0, y = 0;
        while (!visited[x][y]){
            ans.add(matrix[x][y]);
            visited[x][y] = true;
            //更新下一步位置
            int nextX = x + DIRECTIONS[direction][0];
            int nextY = y + DIRECTIONS[direction][1];
            //如果超出边界，则更新方向
            if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited[nextX][nextY]){
                direction = (direction + 1) % 4;
                nextX = x + DIRECTIONS[direction][0];
                nextY = y + DIRECTIONS[direction][1];
            }
            //如果更新方向后，仍然超出边界或已遍历过，则结束循环
            if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited[nextX][nextY]){
                break;
            }
            x = nextX;
            y = nextY;
        }
        return ans;
    }
}
