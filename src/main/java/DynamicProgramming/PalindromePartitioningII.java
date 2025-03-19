package DynamicProgramming;

public class PalindromePartitioningII {
    public int minCut(String s) {
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

        //定义dp2[i]表示下标i及之前分割成回文串的最小分割次数
        //状态转移：dp2[i] = min(dp2[j] + 1) j = 0...i-1
        //初始状态：dp2[0] = 0;
        int[] dp2 = new int[n];
        //初始化
        for(int i = 0 ; i < n ; i++){
            dp2[i] = i;
        }
        //状态转移
        for(int j = 1 ; j < n ; j++){
            if(dp[0][j]){
                dp2[j] = 0;
            }else{
                for(int i = 0 ; i < j ; i++){
                    if(dp[i+1][j]){
                        dp2[j] = Math.min(dp2[j], dp2[i] + 1);
                    }
                }
            }
        }

        return dp2[n - 1];
    }
}
