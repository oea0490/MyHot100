package Hot100.Heap;

import java.util.Random;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        //找第k个最大的数,对应的降序排序数组下标是k - 1
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    public int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];

        Random random = new Random();
        int pivotIndex = random.nextInt(right - left + 1) + left;
        int pivot = nums[pivotIndex];
        int i = left - 1, j = right + 1;
        while(i < j){
            do i++ ; while (nums[i] > pivot);
            do j-- ; while (nums[j] < pivot);
            if (i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        if (k > j) return quickSelect(nums, j + 1, right, k);
        else return quickSelect(nums, left, j, k);
    }
}