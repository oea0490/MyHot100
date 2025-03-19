package Hot100.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder());
        return ans;
    }

    public void dfs(int n, int left, int right, StringBuilder sb) {
        if (left == n && right == n) {
            ans.add(sb.toString());
            return;
        }

        //选择左括号
        if (left < n) {
            sb.append("(");
            dfs(n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        //选择右括号
        if (right < left) {
            sb.append(")");
            dfs(n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
