package BigNumMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BigNumDivide {
    public List<Integer> Divide(List<Integer> A, int B, int C) {
        int lenA = A.size();
        List<Integer> res = new ArrayList<>();
        C = 0;
        for(int i = lenA - 1; i >= 0; i--){
            C = C * 10 + A.get(i);
            res.add(C / B);
            C = C % B;
        }
        Collections.reverse(res);
        while (res.size() > 1 && res.get(res.size() - 1) == 0) {
            res.remove(res.size() - 1);
        }
        return res;
    }
}
