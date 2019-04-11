
import java.awt.*;
import javax.swing.*;

public class gameBoard extends JFrame {

    public gameBoard() {
        super("TicTacToe");
        JPanel board = new JPanel(new GridBagLayout(), true);
        GridBagConstraints c = new GridBagConstraints();

        XObuttons xObuttons = new XObuttons(board, c);

        super.add(board);
        super.setSize(310, 330);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
