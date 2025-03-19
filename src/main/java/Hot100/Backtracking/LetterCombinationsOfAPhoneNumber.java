package Hot100.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    List<String> ans;
    Map<String, String> PhoneMap = new HashMap<>(){{
        put("2" , "abc");
        put("3" , "def");
        put("4" , "ghi");
        put("5" , "jkl");
        put("6" , "mno");
        put("7" , "pqrs");
        put("8" , "tuv");
        put("9" , "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits.isEmpty()) return ans;
        dfs(digits, 0, new StringBuilder());
        return ans;
    }
    public void dfs(String digits, int cur, StringBuilder sb){
        if (cur == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String letters = PhoneMap.get(Character.toString(digits.charAt(cur)));
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            dfs(digits, cur + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
