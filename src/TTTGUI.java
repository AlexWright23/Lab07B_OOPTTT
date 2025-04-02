import javax.swing.*;
import java.awt.*;


public class TTTGUI extends JFrame {
    private TTTTileButton[][] buttons;
    private JLabel turnLabel;
    private TTTGame game;

    public TTTGUI(TTTGame game) {
        this.game = game;
        buttons = new TTTTileButton[3][3];
        turnLabel = new JLabel("Turn: " + game.getCurrentPlayer().getName());

        setTitle("Tic Tac Toe");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(turnLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                TTTTileButton btn = new TTTTileButton(i, j);
                btn.setFont(new Font("Arial", Font.BOLD, 40));
                btn.addActionListener(e -> game.makeMove(btn.getRow(), btn.getCol(), btn));
                buttons[i][j] = btn;
                grid.add(btn);
            }

        add(grid, BorderLayout.CENTER);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> game.resetGame());
        add(resetButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void updateTurnLabel(String name) {
        turnLabel.setText("Turn: " + name);
    }

    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public void disableAll() {
        for (TTTTileButton[] row : buttons)
            for (TTTTileButton btn : row)
                btn.setEnabled(false);
    }

    public void resetButtons() {
        for (TTTTileButton[] row : buttons)
            for (TTTTileButton btn : row) {
                btn.setEnabled(true);
                btn.setText("");
            }
    }
}
