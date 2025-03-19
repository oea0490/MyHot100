package Hot100.Stack;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        //栈中存储的是下标,该题用单调不增栈
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[n];
        for (int i = 0 ; i < n ; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }
}
