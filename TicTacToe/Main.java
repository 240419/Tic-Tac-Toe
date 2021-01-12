package TicTacToe;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Main {
    private static JFrame frame;
    private static JMenuBar menuBar;
    private static JMenu fileMenu, deckMenu;
    private static GUI UI;
    public static void main(String[] args) {
        initializeFrame();
    }

    private static void initializeFrame() {
        frame = new JFrame();
        UI = new HomeGUI();
        frame.add(UI.getPanel(), BorderLayout.CENTER);
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setTitle("Deck of Cards");
        frame.pack();
        frame.setVisible(true);
    }

    // private static void initializeMenuBar() {
    //     menuBar = new JMenuBar();
    //     fileMenu = new JMenu("File");
    //     deckMenu = new JMenu("Deck");
    //     fileMenu.add(new JMenuItem("Open Log"));
    //     fileMenu.add(new JMenuItem("New"));
    //     fileMenu.add(new JMenuItem("Save"));
    //     deckMenu.add(new JMenuItem("Reshuffle"));
    //     deckMenu.add(new JMenuItem("Sort Deck"));
    //     deckMenu.add(new JMenuItem("Show Graphics"));
    //     deckMenu.add(new JMenuItem("Show as Text"));
    //     menuBar.add(fileMenu);
    //     menuBar.add(deckMenu);

    //     for (Component menu : menuBar.getComponents()) {
    //         for (Component item : ((JMenu) menu).getMenuComponents()) {
    //             item.setName(((JMenuItem) item).getText());
    //             ((JMenuItem) item).addActionListener(new MyActionListener());
    //         }
    //     }

    //     System.setProperty("apple.laf.useScreenMenuBar", "true");
    //     System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Stack");
    // }

    // public static void setMenuVisibility(boolean bool) {
    //     for (Component menu : menuBar.getComponents()) {
    //         for (Component item : ((JMenu) menu).getMenuComponents()) {
    //             ((JMenuItem) item).setEnabled(bool);
    //         }
    //     }
    //     File tempFile = new File(Save.getFileName());
        
    //     if (!bool && tempFile.exists()) {
    //         fileMenu.getMenuComponent(0).setEnabled(true);
    //     } else if (bool && !tempFile.exists()) {
    //         fileMenu.getMenuComponent(0).setEnabled(false);
    //     }
    // }

    public static void setGUI(GUI UI) {
        Main.UI = UI;
    }

    public static JFrame getFrame() {
        return Main.frame;
    }

    public static GUI getGUI() {
        return Main.UI;
    }
}