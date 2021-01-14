
package TicTacToe;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;

public class HomeGUI extends GUI implements ActionListener {
    private JLabel introLabel, infoLabel;
    private JTextField numOfPeopleTextField;
    private JButton submitButton;

    public HomeGUI() {
        super("Home");
        // Main.setMenuVisibility(false);

        introLabel = new JLabel("Welcome to Tic Tac Toe!");
        infoLabel = new JLabel("Please type in the number of players. Type \"Computer\" if you would like to play against the computer instead");
        numOfPeopleTextField = new JTextField();
        submitButton = new JButton("Play!");

        introLabel.setFont(new Font(introLabel.getFont().getName(), Font.PLAIN, 60));
        submitButton.addActionListener(this);

        this.getPanel().add(introLabel);
        this.getPanel().add(infoLabel);
        this.getPanel().add(numOfPeopleTextField);
        this.getPanel().add(submitButton);
        this.setComponentAlignment();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        String numOfPeople = numOfPeopleTextField.getText();
        try {
            for (int i = 1; i <= Integer.parseInt(numOfPeople); i++) {
                String id;
                String message = "Please what character player #" + i + " would like to use. ";
                String title = "Character Input";
                id = JOptionPane.showInputDialog(Main.getFrame(), message, title, JOptionPane.OK_OPTION);
                new Player(id);
                System.out.println(id);
            }
            this.getPanel().setVisible(false);
        } catch (Exception exception) {
            if (numOfPeople.contains("comp")) {

            } else {
                infoLabel.setText("Please enter a valid char");
            }
        }
        
    } 
}
