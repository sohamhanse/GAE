
public class nqueen {

    public static void saveboard(char[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe(char[][] board, int row, int col) {

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void placeQ(char[][] board, int row, int n) {
        if (row == n) {
            saveboard(board, n);
            return;
        }

        for (int i = 0; i < board.length; i++) {
                if (isSafe(board, row, i)) {
                    board[row][i] = 'Q';
                    placeQ(board, row+1, n);
                    board[row][i] = '.';
                }
        }
    }

    public static void main(String arg[]) {
        int n = 5;
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        placeQ(board, 0, n);
    }
}
