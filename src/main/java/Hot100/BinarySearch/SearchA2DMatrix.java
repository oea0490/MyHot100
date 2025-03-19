package Hot100.BinarySearch;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        //第一次二分查找
        int left = 0, right = row - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;

            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        int targetRow = right;
        if (targetRow < 0) return false;

        //第二次二分查找
        left = 0;
        right = col - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;

            if (matrix[targetRow][mid] > target) {
                right = mid - 1;
            } else if (matrix[targetRow][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
