package model;

import org.json.JSONObject;
import persistence.Writable;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

// Represents a sound that has a file, a title, and number of plays
public class Sound implements Writable {

    private File file;      // Sound File
    private int numPlays;   // Number of Plays
    private String title;  // Title of sound


    // EFFECTS:  Number of plays is set to 0, title and file are initialized.
    public Sound(String title) {
        this.title = title;
        file = new File(title);
        numPlays = 0;
    }

    // MODIFIES: this
    // EFFECTS: Plays the sound, if file is not found or valid
    // an exception is thrown.
    public synchronized int playMusic() {
        int played = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    //Lines 26-29 code from:
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
                    clip.open(inputStream);
                    clip.start(); //// https://www.youtube.com/watch?v=SyZQVJiARTQ&t=249s
                    //played = 1;
                    numPlays++;
                    EventLog.getInstance().logEvent(new Event("     played sound: " + title));


                    Thread.sleep(clip.getMicrosecondLength() / 1000);


                } catch (Exception e) {
                    System.out.println("file not found");

                }

            }
        }).start();

        return played;


    }


    // EFFECTS: Returns title
    public String getTitle() {
        return title;
    }

    // EFFECTS: Returns file
    public File getFile() {
        return file;
    }

    // EFFECTS: returns number of plays
    public int getNumPlays() {
        return numPlays;

    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("file", file);
        json.put("title", title);
        json.put("number of plays", numPlays);
        return json;
    }


}
