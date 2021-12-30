package ui.buttons;

import model.Sound;

import javax.swing.*;

// Represents a button with an ImageIcon and a Sound
public class TurboButton extends Button {
    private Sound turbo;
    private ImageIcon icon;

    // Effects: Initializes a turbo button and sets the sound
    public TurboButton() {
        super("");
        turbo = new Sound("./data/Turbo.wav");


    }

    // Modifies: this
    // Effects: plays the turbo sound
    @Override
    protected void doAction() {
        this.addActionListener(e -> turbo.playMusic());

    }

    // Modifies: this
    // Effects: sets buttons image
    @Override
    protected void createIcon() {
        icon = new ImageIcon("./data/gunna.png");
        this.setIcon(icon);


    }
}
