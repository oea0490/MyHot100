package Hot100.Matrix;

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        //从右上角开始搜索
        int i = 0, j = col - 1;
        while (i < row && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
