package Hot100.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1 ; i < n ; i++){
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            if (curStart > end){
                ans.add(new int[]{start, end});
                start = curStart;
                end = curEnd;
            }else{
                end = Math.max(end, curEnd);
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][]);
    }
}