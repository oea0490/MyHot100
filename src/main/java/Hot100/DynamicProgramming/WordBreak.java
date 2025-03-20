package Hot100.DynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int maxLen = 0;
        for(String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        Set<String> dict = new HashSet<>(wordDict);
        //定义dp[i]为到前i个字符能否被拼出
        //状态转移方程：dp[i] = dp[j] && dict.contains(s.substring(i,j + 1));
        //初始状态:dp[0] = true
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && dict.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[n];
    }
}
