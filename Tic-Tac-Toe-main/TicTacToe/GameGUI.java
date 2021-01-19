 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GameGUI extends GUI implements ActionListener {
    private JButton[][] guiGrid;
    private ArrayList< ArrayList<String> > gameBoard;
    private int playerTurn;
    private Player currPlayer;
    public static enum turnInfo {
        NOTIFICATION,
        OFF
    }
    private turnInfo turnInfoChoice;

    public GameGUI() {
        super("Game");
        Main.setMenuVisibility(true);
        guiGrid = new JButton[Player.getPlayers().size()+1][Player.getPlayers().size()+1];
        gameBoard = new ArrayList< ArrayList<String> >();
        playerTurn = 0;
        currPlayer = Player.getPlayers().get(0);
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
                square.setName(String.valueOf(i*10 + j));
                newPanel.add(square);
                gameBoard.get(gameBoard.size()-1).add("");
                guiGrid[i][j++] = square;
            }
            i++;
            this.getPanel().add(newPanel);
        }
        displayTurnNotification();
        this.setTurnInfoChoice(turnInfo.NOTIFICATION);
        this.setComponentAlignment();
    }

    @Override
	public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        String message, title;
        
        if (buttonClicked.getText().isEmpty()) {
            currPlayer = Player.getPlayers().get(playerTurn % Player.getPlayers().size()); 
            int row = Integer.parseInt(buttonClicked.getName()) / 10;
            int col = Integer.parseInt(buttonClicked.getName()) % 10;
            buttonClicked.setText(currPlayer.getId());
            gameBoard.get(row).set(col, currPlayer.getId());

            if (currPlayer.canWin(gameBoard)) {
                System.out.println("Win!");
                message = "Player #" + (Player.getPlayers().indexOf(currPlayer)+1) + " wins!";
                title = "Winner!";
                JOptionPane.showMessageDialog(Main.getFrame(), message, title, JOptionPane.OK_OPTION);
                this.getPanel().setVisible(false);
              //   return;

            } else if (TicTacToe.gameOver(gameBoard)) {
                message = "Sorry, nobody won the game :(";
                title = "Game Over";
                JOptionPane.showMessageDialog(Main.getFrame(), message, title, JOptionPane.OK_OPTION);
                this.getPanel().setVisible(false);

            } else {
                playerTurn = (playerTurn+1) % Player.getPlayers().size();
                currPlayer = Player.getPlayers().get(playerTurn);

                if (turnInfoChoice == turnInfo.NOTIFICATION) { displayTurnNotification(); }

                if (currPlayer instanceof Computer) {
                    ArrayList<Integer> coordinates = ((Computer) currPlayer).compChoice(gameBoard);
                    JButton buttonToClick = guiGrid[coordinates.get(0)][coordinates.get(1)];
                    buttonToClick.doClick();
                }
            }
        }
    } 

    private void displayTurnNotification() {
        String message, title;
        if (currPlayer instanceof Computer) {
            message = "Computer with id \"" + currPlayer.getId() + "\" is taking it's turn";
            title = "Computer's turn";
        } else {
            message = String.format("It's now player #%d's turn (%s)", (playerTurn+1), currPlayer.getId());
            title = "Next player's turn";
        }
        JOptionPane.showMessageDialog(Main.getFrame(), message, title, JOptionPane.OK_OPTION);
    }

    public turnInfo getTurnInfoChoice() {
        return this.turnInfoChoice;
    }

    public void setTurnInfoChoice(turnInfo turnInfoChoice) {
        this.turnInfoChoice = turnInfoChoice;
    }
    
}