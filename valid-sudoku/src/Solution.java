import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','5','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        boolean result = isValidSudoku(board);
        System.out.println(result);
    }
    public static boolean isValidSudoku(char[][] board) {
        if (!checkLine(board)) {
            return false;
        }
        if (!checkColumn(board)) {
            return false;
        }
        return checkSquare(board);
    }

    private static boolean checkLine(char[][] board) {
        List<Character> support = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' ) {
                    if (!support.contains(board[i][j])) {
                        support.add(board[i][j]);
                    }
                    else {
                        return false;
                    }
                }
            }
            support = new ArrayList<>();
        }
        return true;
    }

    private static boolean checkColumn(char[][] board) {
        List<Character> support = new ArrayList<>();
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.' ) {
                    if (!support.contains(board[i][j])) {
                        support.add(board[i][j]);
                    }
                    else {
                        return false;
                    }
                }
            }
            support = new ArrayList<>();
        }
        return true;
    }

    private static boolean checkSquare(char[][] board) {
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                List<Character> support = new ArrayList<>();
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (board[i+x][j+y] != '.' ) {
                            if (!support.contains(board[i+x][j+y])) {
                                support.add(board[i+x][j+y]);
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}