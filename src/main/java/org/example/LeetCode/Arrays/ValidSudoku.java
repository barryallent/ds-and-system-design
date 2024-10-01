package org.example.LeetCode.Arrays;

public class ValidSudoku {

        //function to find which box this i and j falls into
        //total 9 boxes 1 to 9
        int findBox(int i, int j) {
            return (i / 3) * 3 + j / 3;
        }

        public boolean isValidSudoku(char[][] board) {

            //arrays to check row, column and boxed for a particular value
            boolean[][] rowCheck = new boolean[9][9];
            boolean[][] columnCheck = new boolean[9][9];
            boolean[][] boxCheck = new boolean[9][9];

            int m=board.length,n=board[0].length;

            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    //if cell is empty then continue
                    if(board[i][j]=='.') {
                        continue;
                    }

                    int num = board[i][j] - '1';

                    //check row
                    if(rowCheck[i][num]) {
                        return false;
                    }
                    rowCheck[i][num]=true;

                    //check column
                    if(columnCheck[j][num]) {
                        return false;
                    }
                    columnCheck[j][num]=true;

                    //check box
                    int box = findBox(i,j);

                    if(boxCheck[box][num]) {
                        return false;
                    }
                    boxCheck[box][num]=true;
                }
            }
            return true;
        }
}
