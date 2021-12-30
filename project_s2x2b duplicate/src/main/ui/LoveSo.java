package ui;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

// Represents the Love Sosa Beat
public class LoveSo {

    private LoveSo() {
    }

    static Clip clip;

    // Static instance of this class
    static LoveSo player = new LoveSo();

    // getter
    public static LoveSo getInstance() {
        return player;
    }

    // Modifies: this
    // Effects: Loads the audio file
    public void loadMusic() {
        try {
            File file = new File("./data/SongProject.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("./data/SongProject.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioStream);


        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
}
