package ui;

import javax.swing.*;
import java.awt.*;

// Represents a Big Button
public class BigButton extends JInternalFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private Component parent;
    private JButton compBtn;

    //Effects: Initializes Big button, sets dimensions and colors of the button
    public BigButton(Component parent) {
        super("Sound compilation maker 3000", false, false, false);
        this.parent = parent;
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setPosition(parent);
        this.setFocusable(false);
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createBevelBorder(1, Color.RED, Color.orange, Color.green, Color.blue));

    }

    // Modifies: this
    // Effects: Sets position of the button relative to its parent
    private void setPosition(Component parent) {
        setLocation(parent.getWidth() - getWidth(), 0);
    }




}


