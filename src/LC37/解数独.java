package LC37;

import java.util.ArrayList;
import java.util.List;

public class 解数独 {
}
class Solution {
    //表示数字j是否在第i行出现过
    private boolean[][] line = new boolean[9][9];
    //表示数字j是否在第i列出现过
    private boolean[][] column = new boolean[9][9];
    //表示数字j是否在第i格出现过
    private boolean[][][] block = new boolean[3][3][9];
    //是否为有效的数独
    private boolean valid = false;
    //spaces中存储了一系列的长度为2的数组。数组标明了空闲空间的位置。
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        //初始化标记数组和剩余空间列表
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {   //数组为空，将之加入剩余空间
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {                    //否则，对其进行标记
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }

        //递归+回溯
        dfs(board, 0);
    }

    /**
     *
     * @param board 数独数组
     * @param pos   空闲空间的索引
     */
    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1]; //(i,j)是空闲空间的位置
        //对于每个空闲空间，枚举所有数字
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            //数字digit能填入相应的行、列、九宫格
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
}

