package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// Represents a BeatPlayer GUI
public class BeatPlayerGUI extends JInternalFrame {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 500;
    private Component parent;
    private JButton playButton;
    private JButton pauseButton;
    private LoveSo loveSo = LoveSo.getInstance();
    private JLabel chiefKeefAnimation;
    private Boolean playGif;

    // Effects: Initializes a BeatPlayer GUI
    public BeatPlayerGUI(Component parent) {
        super("Beat Player 9000", false, false, false);
        this.parent = parent;
        setUp(parent);
        loveSo.loadMusic();

    }

    // Modifies: this
    // Effects: sets dimensions of Beat player gui, and adds components to GUI
    public void setUp(Component parent) {
        this.setLocation(0, parent.getWidth() / 2);
        this.setVisible(true);
        this.setSize(WIDTH, HEIGHT);
        addButtons();
        playGif = false;
        gifAnimate();

    }

    // Modifies: this
    // Effects: Adds play and stop buttons to the GUI,
    //          also adds gif animation to the GUI
    public void addButtons() {
        JPanel buttonLayout = new JPanel();
        buttonLayout.setLayout(new GridLayout(1, 2));

        playButton = new JButton("Play Beat");
        pauseButton = new JButton("Stop Beat");

        playButton.addActionListener(this::playButtonActionPerformed);
        pauseButton.addActionListener(this::pauseButtonActionPerformed);

        buttonLayout.add(playButton);
        buttonLayout.add(pauseButton);

        gifAnimate();

        this.add(buttonLayout, BorderLayout.WEST);

    }

    // Modifies: LoveSo, this
    // Effects: plays LoveSo and displays the gif animation
    public void playButtonActionPerformed(ActionEvent e) {
        loveSo.clip.start();
        chiefKeefAnimation.setVisible(true);


    }

    // Modifies: LoveSo, this
    // Effects: plays LoveSo and hides the gif animation
    public void pauseButtonActionPerformed(ActionEvent e) {
        loveSo.clip.stop();
        chiefKeefAnimation.setVisible(false);
    }

    // Modifies: this
    // Effects: initializes the gif animation
    public void gifAnimate() {
        ImageIcon chiefKeef = new ImageIcon("./data/ChiefKeef.gif");
        chiefKeefAnimation = new JLabel(chiefKeef);
        this.add(chiefKeefAnimation);
        chiefKeefAnimation.setVisible(false);

    }


}




