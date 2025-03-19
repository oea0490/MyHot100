package BigNumMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BigNumSubtract {
    public List<Integer> Subtract(List<Integer> A, List<Integer> B) {
        int lenA = A.size();
        int lenB = B.size();
        if(lenA < lenB) return Subtract(B, A);
        while (lenA > lenB) {
            B.add(0);
            lenB++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = lenA - 1; i >= 0; i--){
            int tmp = A.get(i) - B.get(i);
            if(tmp < 0){
                tmp += 10;
                A.set(i - 1, A.get(i - 1) - 1);
            }
            res.add(tmp);
        }
        while (res.size() > 1 && res.get(res.size() - 1) == 0) res.remove(res.size() - 1);
        Collections.reverse(res);
        return res;
    }
}
