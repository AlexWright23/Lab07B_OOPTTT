//game

public class TTTGame {
    private TTTPlayer player1;
    private TTTPlayer player2;
    private TTTPlayer currentPlayer;
    private TTTBoard board;
    private TTTGUI gui;

    public TTTGame() {
        player1 = new TTTPlayer("Player 1", "X");
        player2 = new TTTPlayer("Player 2", "O");
        currentPlayer = player1;
        board = new TTTBoard();
        gui = new TTTGUI(this);
    }

    public void makeMove(int row, int col, TTTTileButton btn) {
        if (board.makeMove(row, col, currentPlayer.getSymbol())) {
            btn.setText(currentPlayer.getSymbol());
            if (board.checkWin(currentPlayer.getSymbol())) {
                gui.showMessage(currentPlayer.getName() + " wins!");
                gui.disableAll();
            } else if (board.isFull()) {
                gui.showMessage("Draw!");
            } else {
                switchPlayer();
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        gui.updateTurnLabel(currentPlayer.getName());
    }

    public void resetGame() {
        board.resetBoard();
        gui.resetButtons();
        currentPlayer = player1;
        gui.updateTurnLabel(currentPlayer.getName());
    }

    public TTTPlayer getCurrentPlayer() {
        return currentPlayer;
    }
}
