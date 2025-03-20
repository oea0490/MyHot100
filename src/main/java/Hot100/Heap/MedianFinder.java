package Hot100.Heap;

import java.util.PriorityQueue;

public class MedianFinder {
    //保存较大一半数字的小顶堆
    private PriorityQueue<Integer> minHeap;
    //保存较小一半数字的大顶堆
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (minHeap.size() == maxHeap.size()) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (double)(minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return (double)minHeap.peek();
        }
    }
}
