import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Minesweeper extends JFrame {
    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static final int MINES = 10;
    private JButton[][] buttons = new JButton[ROWS][COLS];
    private boolean[][] mines = new boolean[ROWS][COLS];
    private boolean[][] revealed = new boolean[ROWS][COLS];
    private int cellsRevealed = 0;

    public Minesweeper() {
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(ROWS, COLS));
        setResizable(false);

        // Initialize buttons
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                JButton button = new JButton();
                button.setFont(new Font("Arial", Font.BOLD, 16));
                button.addActionListener(new CellClickListener(i, j));
                buttons[i][j] = button;
                add(button);
            }
        }

        placeMines();
        setSize(500, 500);
        setVisible(true);
    }

    private void placeMines() {
        Random rand = new Random();
        int count = 0;
        while (count < MINES) {
            int r = rand.nextInt(ROWS);
            int c = rand.nextInt(COLS);
            if (!mines[r][c]) {
                mines[r][c] = true;
                count++;
            }
        }
    }

    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < ROWS && c >= 0 && c < COLS && mines[r][c]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void revealCell(int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS || revealed[row][col])
            return;

        revealed[row][col] = true;
        cellsRevealed++;
        int count = countAdjacentMines(row, col);

        if (mines[row][col]) {
            buttons[row][col].setText("💣");
            buttons[row][col].setBackground(Color.RED);
            gameOver(false);
        } else if (count > 0) {
            buttons[row][col].setText(String.valueOf(count));
            buttons[row][col].setEnabled(false);
        } else {
            buttons[row][col].setEnabled(false);
            // Recursively reveal neighboring cells
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i != 0 || j != 0)
                        revealCell(row + i, col + j);
                }
            }
        }

        if (cellsRevealed == ROWS * COLS - MINES) {
            gameOver(true);
        }
    }

    private void gameOver(boolean won) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                buttons[i][j].setEnabled(false);
                if (mines[i][j])
                    buttons[i][j].setText("💣");
            }
        }
        String message = won ? "🎉 You Win!" : "💥 Game Over!";
        JOptionPane.showMessageDialog(this, message);
    }

    private class CellClickListener implements ActionListener {
        private int row, col;

        public CellClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {
            revealCell(row, col);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Minesweeper::new);
    }
}
