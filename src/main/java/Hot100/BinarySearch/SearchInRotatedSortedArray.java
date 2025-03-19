package Hot100.BinarySearch;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        //第一次二分查找,先找到旋转点
        int left = 0, right = n - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[n - 1]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //left指向数组最小值,right指向数组最大值
        int rotatedPoint = left;

        //第二次二分查找
        left = rotatedPoint;
        right = rotatedPoint - 1 + n;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid % n] > target){
                right = mid - 1;
            } else if (nums[mid % n] < target){
                left = mid + 1;
            } else {
                return mid % n;
            }
        }
        return -1;
    }
}
