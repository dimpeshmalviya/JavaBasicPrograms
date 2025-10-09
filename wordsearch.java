public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 1, dirs)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx, int[][] dirs) {
        if (idx == word.length()) {
            return true;
        }

        char ch = board[i][j];
        board[i][j] = '#';  

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == word.charAt(idx)) {
                if (dfs(board, word, x, y, idx + 1, dirs)) {
                    board[i][j] = ch;  
                    return true;
                }
            }
        }

        board[i][j] = ch;  
        return false;
    }


    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        System.out.println(ws.exist(board, "ABCCED")); 
        System.out.println(ws.exist(board, "SEE"));    
        System.out.println(ws.exist(board, "ABCB"));   
}
