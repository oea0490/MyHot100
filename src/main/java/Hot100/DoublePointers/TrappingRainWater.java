package Hot100.DoublePointers;

import java.util.Deque;
import java.util.LinkedList;

public class TrappingRainWater {
    public int stackTrap(int[] height) {
        //单调不增栈做法
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        int maxArea = 0;
        for (int right = 0 ; right < n ; right++){
            while (!stack.isEmpty() && height[right] > height[stack.peek()]){
                //先弹出水槽底部
                int BottomIndex = stack.pop();
                //栈空，则缺少左墙，不能接水
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int width = right - left - 1;
                int high = Math.min(height[left], height[right]) - height[BottomIndex];
                maxArea += width * high;
            }
            stack.push(right);
        }
        return maxArea;
    }
    public int DpTrap(int[] height) {
        //动态规划做法
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        //预处理leftMax和rightMax
        leftMax[0] = height[0];
        for (int i = 1 ; i < n ; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2 ; i >= 0 ; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        //计算最大面积
        int maxArea = 0;
        for (int i = 0 ; i < n ; i++){
            maxArea += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return maxArea;
    }
}
