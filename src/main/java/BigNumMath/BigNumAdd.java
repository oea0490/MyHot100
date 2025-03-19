package BigNumMath;

import java.util.ArrayList;
import java.util.List;

public class BigNumAdd {
    public List<Integer> Add(List<Integer> A, List<Integer> B){
        int lenA = A.size();
        int lenB = B.size();
        int tmp = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < lenA || i < lenB; i++){
            if(i < lenA) tmp += A.get(i);
            if(i < lenB) tmp += B.get(i);
            res.add(tmp % 10);
            tmp /= 10;
        }
        if(tmp != 0) res.add(tmp);
        return res;
    }
}
