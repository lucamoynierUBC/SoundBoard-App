package ui.buttons;

import model.Sound;

import javax.swing.*;

// Represents a button with an ImageIcon and a Sound
public class PierreButton extends Button {
    Sound pierre;
    ImageIcon icon;

    // Effects: Initializes a pierreButton and sets the sound
    public PierreButton() {
        super("");
        pierre = new Sound("./data/Yo_Pierre.wav");

    }

    // Modifies: this
    // Effects: Plays sound
    @Override
    protected void doAction() {
        this.addActionListener(e -> pierre.playMusic());

    }

    // Modifies: this
    // Effects: adds Image to the button
    @Override
    protected void createIcon() {
        icon = new ImageIcon("./data/carti.jpg");
        this.setIcon(icon);


    }


}
