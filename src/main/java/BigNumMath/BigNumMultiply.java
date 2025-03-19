package BigNumMath;

import java.util.ArrayList;
import java.util.List;

public class BigNumMultiply {
    public List<Integer> Multiply(List<Integer> A, int B) {
        List<Integer> res = new ArrayList<>();
        if(B == 0){
            res.add(0);
            return res;
        }
        int lenA = A.size();
        int tmp = 0;
        for(int i = 0 ; i < lenA || tmp != 0; i++){
            if(i < lenA) tmp += A.get(i) * B;
            res.add(tmp % 10);
            tmp /= 10;
        }
        return res;
    }
}
