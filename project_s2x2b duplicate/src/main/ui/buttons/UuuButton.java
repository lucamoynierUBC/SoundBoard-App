package ui.buttons;

import model.Sound;

import javax.swing.*;

// Represents a button with an ImageIcon and a Sound
public class UuuButton extends Button {
    private Sound uuu;
    private ImageIcon icon;

    // Effects: Initializes the button and sets the sound
    public UuuButton() {
        super("");
        uuu = new Sound("./data/UUU.wav");


    }

    // Modifies: this
    // Effects: plays the uuu sound
    @Override
    protected void doAction() {
        this.addActionListener(e -> uuu.playMusic());

    }

    // Modifies: this
    // Effects: sets an image to the button
    @Override
    protected void createIcon() {
        icon = new ImageIcon("./data/soulja.png");
        this.setIcon(icon);


    }
}
