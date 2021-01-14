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
    private JButton[][] guiGrid;
    private ArrayList< ArrayList<String> > gameBoard;

    private JLabel turnLabel;
    private int turns;
    public GameGUI() {
        super("Game");
        guiGrid = new JButton[Player.getPlayers().size()+1][Player.getPlayers().size()+1];
        gameBoard = new ArrayList< ArrayList<String> >();
        turnLabel = new JLabel(Player.getPlayers().get(0).getId());
        this.getPanel().add(turnLabel);
        turns = 0;
        int i = 0;
        for (JButton[] row : guiGrid) {
            JPanel newPanel = new JPanel();
            Dimension frameSize = Main.getFrame().getSize();
            int height = (int) (frameSize.getHeight())/guiGrid.length - 30;
            gameBoard.add(new ArrayList<String>());
            int j = 0;
            for (JButton square : row) {
                square = new JButton();
                square.setBorder(BorderFactory.createLineBorder(Color.BLACK, 12));
                square.setPreferredSize(new Dimension(height, height));
                square.addActionListener(this);
                square.setName(String.valueOf(i*10 + j++));
                newPanel.add(square);
                gameBoard.get(gameBoard.size()-1).add("");
            }
            i++;
            this.getPanel().add(newPanel);
        }
        this.setComponentAlignment();
    }

    @Override
	public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        int row, col;
        
        if (buttonClicked.getText().isEmpty()) {
            Player player = Player.getPlayers().get(turns % Player.getPlayers().size()); 
            buttonClicked.setText(player.getId());
            row = Integer.parseInt(buttonClicked.getName()) / 10;
            col = Integer.parseInt(buttonClicked.getName()) % 10;
            // System.out.println(row + " " + col);
            gameBoard.get(row).set(col, player.getId());
            turnLabel.setText(Player.getPlayers().get(++turns % Player.getPlayers().size()).getId());
        }

        for (Player player : Player.getPlayers()) {
            if (TicTacToe.winOpt(player.getId(), gameBoard, gameBoard.size())) {
                System.out.println("Win!");
                JOptionPane.showMessageDialog(Main.getFrame(), "Player #" + (Player.getPlayers().indexOf(player)+1) + " wins!", "Winner!", JOptionPane.OK_OPTION);
            }
        }
    } 
    
}
