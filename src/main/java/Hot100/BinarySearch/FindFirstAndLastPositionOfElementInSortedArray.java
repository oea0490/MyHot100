package Hot100.BinarySearch;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int leftIndex = findFirst(nums, target);
        int rightIndex= findFirst(nums, target + 1) - 1;
        // 判断target是否在数组中
        if (leftIndex >= nums.length || rightIndex < 0) return ans;
        if (nums[leftIndex] != target || nums[rightIndex] != target) return ans;
        ans[0] = leftIndex;
        ans[1] = rightIndex;
        return ans;
    }

    public int findFirst(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}