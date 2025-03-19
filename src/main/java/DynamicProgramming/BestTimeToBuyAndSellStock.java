package DynamicProgramming;

import java.util.Deque;
import java.util.LinkedList;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int index = stack.pop();
                maxProfit = Math.max(maxProfit, prices[i] - prices[index]);
            }
            stack.push(i);
        }
        return maxProfit;
    }
}
