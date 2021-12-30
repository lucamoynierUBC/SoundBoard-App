package ui.buttons;

import javax.swing.*;
import java.awt.*;

// Represents an abstract button class
public abstract class Button extends JButton {
    private JButton button;
    private boolean active;

    // Effects: Initializes a button with a name, aesthetic features, and an action Listener.
    public Button(String name) {
        super(name);
        this.doAction();
        this.createIcon();
        this.setFocusable(false);
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createBevelBorder(1, Color.green, Color.orange, Color.red, Color.blue));
        active = false;

    }

    // Modifies: this
    // Effects: Associate button with an Action Listener
    protected abstract void doAction();

    // Modifies: this
    // Effects: Abstract method that sets the icon of the button
    protected abstract void createIcon();


}
