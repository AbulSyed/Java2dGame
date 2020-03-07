package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel {
    private Game game;
    private JPanel mainPanel;
    private JButton pauseButton;
    private JButton startButton;
    private JButton quitButton;
    private JButton hintButton;
    private JButton skiplevelButton;

    public ControlPanel(Game game) {


        this.game=game;
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pause");
                game.pause();
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start");
                game.start();
            }
        });
        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(hintButton, "Collect Gold to advance to next level, you can click to drop boxes.");
            }
        });
        skiplevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Skipping level");
                game.goNextLevel();
            }
        });
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }

}
