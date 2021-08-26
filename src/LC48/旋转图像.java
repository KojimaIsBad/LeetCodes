package LC48;

public class 旋转图像 {
}
class Solution {
    /**
     * 水平翻转，再对角线反转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //水平翻转
        for(var i=0;i<n/2;i++){
            for(var j=0;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
        //沿着对角线对称，这里选择下半对角线
        for(var i=0;i<n;i++){
            for(var j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * 找规律
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        var n = matrix.length;
        for(var i=0;i<n/2;i++){
            //考虑当n为奇数的特殊情况，边界条件应限制为(n+1)/2
            for(var j=0;j<(n+1)/2;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}