public class TTTBoard {
    private String[][] board;

    public TTTBoard() {
        board = new String[3][3];
        resetBoard();
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = "";
    }

    public boolean makeMove(int row, int col, String symbol) {
        if (board[row][col].isEmpty()) {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean checkWin(String symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(symbol) && board[i][1].equals(symbol) && board[i][2].equals(symbol)) return true;
            if (board[0][i].equals(symbol) && board[1][i].equals(symbol) && board[2][i].equals(symbol)) return true;
        }
        return board[0][0].equals(symbol) && board[1][1].equals(symbol) && board[2][2].equals(symbol) ||
                board[0][2].equals(symbol) && board[1][1].equals(symbol) && board[2][0].equals(symbol);
    }

    public boolean isFull() {
        for (String[] row : board)
            for (String cell : row)
                if (cell.isEmpty()) return false;
        return true;
    }
}
