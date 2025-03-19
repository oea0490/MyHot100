package Hot100.Stack;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        //栈中存储的是数组元素的下标,该题用单调不增栈
        Deque<Integer> stack = new LinkedList<>();
        //left[i]表示当前位置左边第一个小于当前位置高度的位置
        int[] left = new int[n];
        //right[i]表示当前位置右边第一个小于当前位置高度的位置
        int[] right = new int[n];

        for (int i = 0 ; i < n ; i++){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1 ; i >= 0 ; i--){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0 ; i < n ; i++){
            int area = (right[i] - left[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
