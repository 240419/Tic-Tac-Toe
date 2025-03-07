package TicTacToe;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;

public class HomeGUI extends GUI implements ActionListener {
    private JLabel introLabel, peopleInfoLabel, compInfoLabel;
    private JTextField numOfPeopleTextField, numOfCompsTextField;
    private JButton submitButton;

    public HomeGUI() {
        super("Home");
        Main.setMenuVisibility(false);
        introLabel = new JLabel("Welcome to Tic Tac Toe!");
        peopleInfoLabel = new JLabel("Please type in the number of human players.");
        compInfoLabel = new JLabel("Please type in the number of computer players.");
        numOfPeopleTextField = new JTextField();
        numOfCompsTextField = new JTextField();
        submitButton = new JButton("Play!");

        introLabel.setFont(new Font(introLabel.getFont().getName(), Font.PLAIN, 60));
        submitButton.addActionListener(this);

        this.getPanel().add(introLabel);
        this.getPanel().add(peopleInfoLabel);
        this.getPanel().add(numOfPeopleTextField);
        this.getPanel().add(compInfoLabel);
        this.getPanel().add(numOfCompsTextField);
        this.getPanel().add(submitButton);
        this.setComponentAlignment();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        int numOfPeople = 0, numOfComps = 0;
        Player.getPlayers().clear();
        Computer.setNumOfComputers(0);
        String message = "Please enter a valid number of players/computers. The total number of players must be less than 10!";
        String title = "Invalid input";
        try {
            numOfPeople = Integer.parseInt(numOfPeopleTextField.getText());
            numOfComps = Integer.parseInt(numOfCompsTextField.getText());
            if (numOfPeople < 0 || numOfComps < 0 || (numOfPeople + numOfComps) > 10) {
                throw new Exception();
            }
            for (int i = 1; i <= numOfPeople; i++) {
                String id;
                message = "Please what character player #" + i + " would like to use. ";
                title = "Character Input";
                id = JOptionPane.showInputDialog(Main.getFrame(), message, title, JOptionPane.OK_OPTION);

                if (id == null) {
                    return;
                } else if (!Player.isValidChar(id)) {
                    message = "Please enter a valid letter that also hasn't been used already!";
                    title = "Invalid input";
                    i--;
                    JOptionPane.showMessageDialog(Main.getFrame(), message, title, JOptionPane.OK_OPTION);
                } else {
                    new Player(id);
                }
            }
            for (int i = 1; i <= numOfComps; i++) { new Computer(); }
            this.getPanel().setVisible(false);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(Main.getFrame(), message, title, JOptionPane.OK_OPTION);
        }
    }
}
