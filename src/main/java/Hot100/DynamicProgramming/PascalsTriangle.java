package Hot100.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        //定义dp[i][j]为第i行i列的杨辉数
        //状态转移方程：dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
        //初始状态：dp[0][0] = 1;dp[i][0] = 1;dp[i][i] = 1;
        int[][] dp = new int[numRows][numRows];
        //初始化
        for (int i = 0; i < numRows; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        //状态转移
        for (int i = 2; i < numRows; i++){
            for (int j = 1; j < i; j++){
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                temp.add(dp[i][j]);
            }
            ans.add(temp);
        }
        return ans;
    }
}
