package ui.buttons;

import model.Sound;

import javax.swing.*;

// Represents a button that plays the Damn sound
public class DamnButton extends Button {
    private Sound damn;
    private ImageIcon icon;


    // Effects: Initializes a Damn sound button and sets the Sound
    public DamnButton() {
        super("");
        damn = new Sound("./data/Damn_son.wav");

    }

    // Modifies: this
    // Effects: When button is clicked, damn son is played
    @Override
    protected void doAction() {
        this.addActionListener(e -> damn.playMusic());

    }

    // Modifies: this
    // Effects: Sets and Image to the button
    @Override
    protected void createIcon() {
        icon = new ImageIcon("./data/Damn.jpg");
        this.setIcon(icon);

    }
}
