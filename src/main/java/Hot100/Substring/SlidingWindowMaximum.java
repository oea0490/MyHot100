package Hot100.Substring;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0 ; i < n ; i++){
            //入滑动窗口
            int[] cur = new int[]{nums[i], i};
            pq.offer(cur);
            if (i < k - 1) continue;
            //出滑动窗口
            while (pq.peek()[1] < i - k + 1){
                pq.poll();
            }
            //更新答案
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
