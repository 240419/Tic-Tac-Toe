package TicTacToe;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

public class GameGUI extends GUI implements ActionListener {
    private JButton[][] grid;
    public GameGUI() {
        super("Game");
        grid = new JButton[Player.getPlayers().size()+1][Player.getPlayers().size()+1];
        int i = 0;
        for (JButton[] row : grid) {
            JPanel newPanel = new JPanel();
            Dimension frameSize = Main.getFrame().getSize();
            int height = (int) (frameSize.getHeight())/grid.length - 30;
            for (JButton square : row) {
                square = new JButton("X");
                square.setBorder(BorderFactory.createLineBorder(Color.BLACK, 12));
                System.out.println("F: " + frameSize.getHeight() +  " - H: " + height);
                square.setPreferredSize(new Dimension(height, height));
                newPanel.add(square);
            }
            this.getPanel().add(newPanel);
        }
    }

    @Override
	public void actionPerformed(ActionEvent e) {

    } 
    
}
