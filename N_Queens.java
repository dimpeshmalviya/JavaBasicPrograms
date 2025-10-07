public class N_Queens {
    public static void solveNQueens(int n) {
        int[] board = new int[n];
        if (placeQueens(board, 0, n)) {
            printSolution(board);
        } else {
            System.out.println("Solution does not exist");
        }
    }

    private static boolean placeQueens(int[] board, int row, int n) {
        if (row >= n) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row] = col;
                if (placeQueens(board, row + 1, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || 
                board[i] - i == col - row || 
                board[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    private static void printSolution(int[] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        solveNQueens(n);
    }
}