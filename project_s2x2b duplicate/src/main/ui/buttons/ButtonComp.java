package ui.buttons;

import javax.swing.*;
import java.awt.*;

// Represents a button to create a compilation
public class ButtonComp extends JButton {
    private JButton button;
    private boolean active;

    // Effects: Initializes ButtonComp with colors and actionLister
    public ButtonComp(AbstractAction aa) {
        super(aa);
        this.setFocusable(false);
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createBevelBorder(1, Color.pink, Color.yellow, Color.CYAN, Color.magenta));


    }

}

