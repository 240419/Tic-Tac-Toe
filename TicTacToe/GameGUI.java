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
    private int playerTurn;

    public GameGUI() {
        super("Game");
        Main.setMenuVisibility(true);
        guiGrid = new JButton[Player.getPlayers().size()+1][Player.getPlayers().size()+1];
        gameBoard = new ArrayList< ArrayList<String> >();
        turnLabel = new JLabel(String.format("Player #%d's turn (%s) ", 1, Player.getPlayers().get(0).getId()));
        // turnLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 12));
        turnLabel.setPreferredSize(new Dimension(turnLabel.getWidth(), 50));
        this.getPanel().add(turnLabel);
        playerTurn = 0;
        int i = 0;
        for (JButton[] row : guiGrid) {
            JPanel newPanel = new JPanel();
            Dimension frameSize = Main.getFrame().getSize();
            int height = (int) (frameSize.getHeight())/guiGrid.length - 25;
            gameBoard.add(new ArrayList<String>());
            int j = 0;
            for (JButton square : row) {
                square = new JButton();
                square.setBorder(BorderFactory.createLineBorder(Color.BLACK, 12));
                square.setPreferredSize(new Dimension(height, height));
                square.addActionListener(this);
                square.setName(String.valueOf(i*10 + j));
                newPanel.add(square);
                gameBoard.get(gameBoard.size()-1).add("");
                guiGrid[i][j++] = square;
            }
            i++;
            this.getPanel().add(newPanel);
        }
        this.setComponentAlignment();
    }

    @Override
	public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        String message, title;
        Player currPlayer;
        
        if (buttonClicked.getText().isEmpty()) {
            currPlayer = Player.getPlayers().get(playerTurn % Player.getPlayers().size()); 
            int row = Integer.parseInt(buttonClicked.getName()) / 10;
            int col = Integer.parseInt(buttonClicked.getName()) % 10;
            buttonClicked.setText(currPlayer.getId());
            gameBoard.get(row).set(col, currPlayer.getId());

            playerTurn = (playerTurn+1) % Player.getPlayers().size();
            currPlayer = Player.getPlayers().get(playerTurn);
            turnLabel.setText(String.format("Player #%d's turn (%s)", (playerTurn+1), currPlayer.getId()));
            for (Player player : Player.getPlayers()) {
              if (player.canWin(gameBoard)) {
                  System.out.println("Win!");
                  message = "Player #" + (Player.getPlayers().indexOf(player)+1) + " wins!";
                  title = "Winner!";
                  JOptionPane.showMessageDialog(Main.getFrame(), message, title, JOptionPane.OK_OPTION);
                  this.getPanel().setVisible(false);
                  return;
              }
          }
            if (currPlayer instanceof Computer) {
                Computer compPlayer = (Computer) currPlayer;
                ArrayList<Integer> coordinates = compPlayer.compChoice(gameBoard);
                JButton buttonToClick = guiGrid[coordinates.get(0)][coordinates.get(1)];
                message = "Computer with id \"" + compPlayer.getId() + "\" is taking it's turn";
                title = "Computer's turn";
                JOptionPane.showMessageDialog(Main.getFrame(), message, title, JOptionPane.OK_OPTION);
                buttonToClick.doClick();
                return;
            }
        }

        for (Player player : Player.getPlayers()) {
            if (player.canWin(gameBoard)) {
                System.out.println("Win!");
                message = "Player #" + (Player.getPlayers().indexOf(player)+1) + " wins!";
                title = "Winner!";
                JOptionPane.showMessageDialog(Main.getFrame(), message, title, JOptionPane.OK_OPTION);
                this.getPanel().setVisible(false);
                return;
            }
        }

        if (TicTacToe.gameOver(gameBoard)) {
            message = "Sorry, nobody won the game :(";
            title = "Game Over";
            JOptionPane.showMessageDialog(Main.getFrame(), message, title, JOptionPane.OK_OPTION);
            this.getPanel().setVisible(false);
        }
    } 
    
}