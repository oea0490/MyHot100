package Hot100.Matrix;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //确定待旋转的区域
        int row = (n + 1) / 2;
        int col = n / 2;
        for (int i = 0 ; i < row ; i++){
            for (int j = 0 ; j < col ; j++){
                //每次旋转交换四个元素位置
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1- i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}
