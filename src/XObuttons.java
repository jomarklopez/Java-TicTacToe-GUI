
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class XObuttons extends JButton implements ActionListener {

    private byte turn = 0;
    int elements = 4;
    JButton[] jb = new JButton[12];

    @SuppressWarnings("LeakingThisInConstructor")
    public XObuttons(JPanel b, GridBagConstraints con) {

        con.gridx = 0;
        con.gridy = 0;

        for (int i = 0; i < 12; i++) {
            jb[i] = new JButton();
            jb[i].setPreferredSize(new Dimension(100, 100));
            jb[i].addActionListener(this);
            b.add(jb[i], con);
            if (con.gridx == 3) {
                con.gridx = 0;
                con.gridy++;
            } else {
                con.gridx++;
            }
        }
    }
    //4 4 1
    //9 9 2
    boolean winconditions() {
      /*0 1 2
        3 4 5
        6 7 8*/
        //Horizontal Check
        if (!jb[0].getText().isEmpty() && !jb[0].getText().isEmpty() && !jb[0].getText().isEmpty()) {
            
            if (jb[0].getText().equals(jb[1].getText()) && jb[1].getText().equals(jb[2].getText())) {
                return true;
            }
        }
        if (!jb[3].getText().isEmpty() && !jb[4].getText().isEmpty() && !jb[5].getText().isEmpty()) {
            
            if (jb[3].getText().equals(jb[4].getText()) && jb[4].getText().equals(jb[5].getText())) {
                return true;
            } 
        }
        if (!jb[6].getText().isEmpty() && !jb[7].getText().isEmpty() && !jb[8].getText().isEmpty()) {
            
            if (jb[6].getText().equals(jb[7].getText()) && jb[7].getText().equals(jb[8].getText())) {
                return true;
            } 
        }
        ///Vertical Check
        if (!jb[0].getText().isEmpty() && !jb[3].getText().isEmpty() && !jb[6].getText().isEmpty()) {
            
            if (jb[0].getText().equals(jb[3].getText()) && jb[3].getText().equals(jb[6].getText())) {
                return true;
            }
        }
        if (!jb[1].getText().isEmpty() && !jb[4].getText().isEmpty() && !jb[7].getText().isEmpty()) {
            
            if (jb[1].getText().equals(jb[4].getText()) && jb[4].getText().equals(jb[7].getText())) {
                return true;
            } 
        }
        if (!jb[2].getText().isEmpty() && !jb[5].getText().isEmpty() && !jb[8].getText().isEmpty()) {
            
            if (jb[2].getText().equals(jb[5].getText()) && jb[5].getText().equals(jb[8].getText())) {
                return true;
            } 
        }
        //Diagonal Check
        if (!jb[0].getText().isEmpty() && !jb[4].getText().isEmpty() && !jb[8].getText().isEmpty()) {
            
            if (jb[0].getText().equals(jb[4].getText()) && jb[4].getText().equals(jb[8].getText())) {
                return true;
            }
        }
        if (!jb[2].getText().isEmpty() && !jb[4].getText().isEmpty() && !jb[6].getText().isEmpty()) {
            
            if (jb[2].getText().equals(jb[4].getText()) && jb[4].getText().equals(jb[6].getText())) {
                return true;
            } 
        }
        return false;
    }
    
    void newGame() {
        
        for (int i = 0; i < 9; i++) {
            jb[i].setText("");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(turn);
        JButton butclicked = (JButton) e.getSource();
        if (butclicked.getText().isEmpty()) {
            if (turn % 2 == 0) {
                butclicked.setText("X");
                turn++;
            } else {
                butclicked.setText("O");
                turn++;
            }
        }

        if (winconditions() == true) {

            Object[] options = {"Restart",
                "Quit"};
            int n = JOptionPane.showOptionDialog(null,
                    "Player " + (((turn-1) % 2)+1) + " WON!",
                    "GAME OVER",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (n == JOptionPane.YES_OPTION) {
                newGame();
                turn = 0;
            } else {
                System.exit(0);
            }
        }
        System.out.println(turn);
    }
}
