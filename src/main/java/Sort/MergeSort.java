package Sort;

public class MergeSort {
    private int[] tmp;

    public void mergeSort(int[] nums) {
        //初始化 tmp 数组
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int left, int right) {
        if(left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        int i = left, j = mid + 1, k = left;
        while(i <= mid && j <= right) {
            if(nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            }else {
                tmp[k++] = nums[j++];
            }
        }
        while(i <= mid) {tmp[k++] = nums[i++];}
        while(j <= right) {tmp[k++] = nums[j++];}

        // 将 tmp 的内容复制回 nums
        for (int idx = left; idx <= right; idx++) {
            nums[idx] = tmp[idx];
        }

    }
}