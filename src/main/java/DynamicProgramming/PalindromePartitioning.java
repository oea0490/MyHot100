package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    private List<List<String>> ans;
    private List<String> path;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        int n = s.length();
        //定义dp[i][j]表示下标i到下标j是否为回文串
        //状态转移：dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
        //初始状态：dp[i][i] = true;
        boolean[][] dp = new boolean[n][n];
        //初始化
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        //状态转移
        for(int j = 1 ; j < n ; j++){
            for(int i = 0 ; i < j ; i++){
                if(i + 1 <= j - 1){
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                }else{
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
            }
        }

        dfs(s, 0, dp);
        return ans;
    }

    public void dfs(String s, int start, boolean[][] dp){
        if(start == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = start ; i < s.length() ; i++){
            if(dp[start][i]){
                path.add(s.substring(start, i+1));
                dfs(s, i+1, dp);
                path.remove(path.size()-1);
            }
        }
    }
}
