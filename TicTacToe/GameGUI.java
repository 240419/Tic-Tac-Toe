package TicTacToe;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;

public class GameGUI extends GUI implements ActionListener {
    private JButton[][] grid;
    private JLabel turnLabel;
    private int turns;
    public GameGUI() {
        super("Game");
        grid = new JButton[Player.getPlayers().size()+1][Player.getPlayers().size()+1];
        turnLabel = new JLabel(Player.getPlayers().get(0).getId());
        turns = 0;

        for (JButton[] row : grid) {
            JPanel newPanel = new JPanel();
            Dimension frameSize = Main.getFrame().getSize();
            int height = (int) (frameSize.getHeight())/grid.length - 30;
            for (JButton square : row) {
                square = new JButton();
                square.setBorder(BorderFactory.createLineBorder(Color.BLACK, 12));
                square.setPreferredSize(new Dimension(height, height));
                square.addActionListener(this);
                newPanel.add(square);
            }
            this.getPanel().add(newPanel);
        }
    }

    @Override
	public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        if (buttonClicked.getText().isEmpty()) {
            Player player = Player.getPlayers().get(turns++ % Player.getPlayers().size()); 
            buttonClicked.setText(player.getId());
            // turnLabel.setText("player.getId());
        }

        // for (Player player : Player.getPlayers()) {
        //     if (player.canWin()) {
        //         System.out.println("Win!");
        //     }
        // }
    } 
    
}
