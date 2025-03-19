package Hot100.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    final int [][] DIRECTION = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int time = -1;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (queue.isEmpty()) {
            if (fresh == 0) return 0;
            return -1;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int [] cur = queue.poll();
                for (int[] direction : DIRECTION) {
                    int x = cur[0] + direction[0];
                    int y = cur[1] + direction[1];
                    if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        fresh--;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            time++;
        }

        if (fresh != 0) return -1;

        return time;
    }
}
