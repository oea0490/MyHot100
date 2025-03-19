package Hot100.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> ans;
    List<String> path;
    boolean[][] isPalindrome;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        int n = s.length();
        //定义isPalindrome[i][j]表示下标i到下标j是否为回文串
        //状态转移：isPalindrome[i][j] = isPalindrome[i+1][j-1] && s[i] == s[j]
        //初始状态：isPalindrome[i][i] = true;
        isPalindrome = new boolean[n][n];

        //初始状态
        for (int i = 0 ; i < n ; i++){
            isPalindrome[i][i] = true;
        }
        //状态转移
        for (int j = 1 ; j < n ; j++){
            for (int i = 0 ; i < j ; i++){
                if(i + 1 <= j - 1){
                    isPalindrome[i][j] = isPalindrome[i+1][j-1] && s.charAt(i) == s.charAt(j);
                }else{
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                }
            }
        }

        dfs(s, 0);
        return ans;
    }

    public void dfs(String s, int cur){
        if(cur == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = cur ; i < s.length() ; i++){
            if(isPalindrome[cur][i]){
                path.add(s.substring(cur, i+1));
                dfs(s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
