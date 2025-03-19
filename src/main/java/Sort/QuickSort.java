package Sort;

public class QuickSort {
    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = nums[left];//枢轴取左、右、中、随机都可以
        int i = left - 1, j = right + 1;
        while (i < j) {
            do i++;while (nums[i] < pivot);
            do j--;while (nums[j] > pivot);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }
}