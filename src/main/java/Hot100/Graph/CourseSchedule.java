package Hot100.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    //CourseEdges[i]表示课程i的后继课程
    List<List<Integer>> CourseEdges;
    //inDegree[i]表示课程i的入度
    int[] inDegree;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //初始化
        CourseEdges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            CourseEdges.add(new ArrayList<>());
        }
        inDegree = new int[numCourses];
        //构建拓扑顺序图和入度数组
        for (int[] prerequisite : prerequisites) {
            CourseEdges.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        //借助队列进行拓扑排序
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            //学习完cur课程后,更新cur课程的后继课程的入度,将入度为0的课程加入队列
            for (int next : CourseEdges.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        //如果拓扑排序的课程数量等于课程总数,则说明可以完成所有课程
        return count == numCourses;
    }
}
