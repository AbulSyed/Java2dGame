package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{

    private JPanel menuPanel;
    private JButton startButton;
    private JButton quitButton;
    private JButton instructionButton;

    public MainMenu() {
        add(menuPanel);
        setSize(500,500);
        setVisible(true);


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Game();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        instructionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(instructionButton, "Use LEFT, RIGHT, UP keys to move. Click to drop boxes to help jump to higher platforms.");
            }
        });
    }

    public static void main() {
        MainMenu menu = new MainMenu();
        menu.add(menu.getMenuPanel(), BorderLayout.CENTER);
        menu.setVisible(true);
    }

    public JPanel getMenuPanel(){
        return menuPanel;
    }

    public static void main(String [] args) {
        MainMenu menu = new MainMenu();
    }
}
