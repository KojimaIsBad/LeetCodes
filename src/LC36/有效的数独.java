package LC36;

import java.util.HashMap;
import java.util.Map;

public class 有效的数独 {
}

class Solution {
    public boolean isValidSudoku0(char[][] board) {
        for(var i=0;i<9;i++){
            var map1 = new HashMap<Character,Integer>();
            var map2 = new HashMap<Character,Integer>();
            for(var j=0;j<9;j++){
                if(board[i][j]!='.'){
                    map1.put(board[i][j],map1.getOrDefault(board[i][j],0)+1);
                    if(map1.get(board[i][j])>1)
                        return false;
                }
                if(board[j][i]!='.'){
                    map2.put(board[j][i],map2.getOrDefault(board[j][i],0)+1);
                    if(map2.get(board[j][i])>1)
                        return false;
                }
            }
        }
        for(int a=0;a<3;a++){
            for(int b=0;b<3;b++){
                var map = new HashMap<Character,Integer>();
                for(var i=3*a;i<3*a+3;i++){
                    for(var j=3*b;i<3*b+3;j++){
                        if(board[i][j]!='.'){
                            map.put(board[i][j],map.getOrDefault(board[i][j],0)+1);
                            if(map.get(board[i][j])>1)
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * 一次迭代
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // init data
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }
        return true;
    }
}