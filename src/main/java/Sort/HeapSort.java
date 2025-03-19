package Sort;

public class HeapSort {
    int[] heap;
    int size;

    public void heapSort(int[] nums) {
        int n = nums.length;

        //初始化堆
        heap = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            heap[i] = nums[i - 1];
        }
        size = n;

        //堆化
        for (int i = n / 2; i >= 1; i--) {
            heapify(i);
        }

        //堆排序
        for (int i = 0 ; i < n; i++){
            nums[i] = heap[i + 1];
        }
    }

    public void heapify(int u) {
        int t = u;
        if (u * 2 <= size && heap[u * 2] > heap[t]) {
            t = u * 2;
        }
        if (u * 2 + 1 <= size && heap[u * 2 + 1] > heap[t]) {
            t = u * 2 + 1;
        }
        if (t != u) {
            int temp = heap[t];
            heap[t] = heap[u];
            heap[u] = temp;
            heapify(t);
        }
    }
}
