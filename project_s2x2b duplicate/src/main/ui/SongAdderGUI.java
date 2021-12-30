package ui;

import model.Sound;
import model.SoundList;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.buttons.ButtonComp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

// Represents a GUI where songs can be added a compilations, which can be played,
// loaded, and saved
public class SongAdderGUI extends JInternalFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private Component parent;
    private SoundList compilation;
    private JPanel compilationDisplay;
    private JLabel songAdded;
    private ListDisplay listDisplay;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/workroom.json";

    // Effects: Initializes the SongAdderGUIr
    public SongAdderGUI(Component parent) {
        super("Compilation Creation 3000", false, false, false);
        this.parent = parent;
        compilation = new SoundList();

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setPosition(parent);
        this.setLayout(new BorderLayout());
        compilationDisplay = new JPanel();

        songAdded = new JLabel();
        songAdded.setFont(new Font("Monospaced", Font.ITALIC, 18));

        compilationDisplay.setPreferredSize(new Dimension(WIDTH, 50));
        compilationDisplay.setBackground(Color.RED);
        compilationDisplay.add(songAdded);
        listDisplay = new ListDisplay();

        addButtons();
    }

    // Modifies: this
    // Effects: Sets the position of the Song Adder GUI
    public void setPosition(Component parent) {
        setLocation(parent.getWidth() - getWidth(), 0);

    }

    // Modifies: this
    // Effects: populates the buttons to be used to create/load/save a compilation,
    //          adds listDisplay that Lists sounds in the compilation
    public void addButtons() {
        JPanel buttonLayout = new JPanel();

        buttonLayout.setLayout(new GridLayout(3, 2));

        buttonLayout.add(new ButtonComp(new DamnSoundAdderAction()));
        buttonLayout.add(new ButtonComp(new UuuSoundAdderAction()));
        buttonLayout.add(new ButtonComp(new TurboSoundAdderAction()));
        buttonLayout.add(new ButtonComp(new CartiSoundAdderAction()));
        buttonLayout.add(new ButtonComp(new PlayCompilation()));
        buttonLayout.add(new ButtonComp(new SaveComp()));
        buttonLayout.add(new ButtonComp(new LoadComp()));


        this.add(buttonLayout);
        this.add(listDisplay, BorderLayout.SOUTH);
        this.add(compilationDisplay, BorderLayout.NORTH);


    }

    // Represents a listener for a button
    private class CartiSoundAdderAction extends AbstractAction {

        // Modifies: this
        // Effects: Initializes action Listener with an ImageIcon
        CartiSoundAdderAction() {
            ImageIcon icon = new ImageIcon("./data/carti.jpg");
            this.putValue(Action.SMALL_ICON, icon);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Sound pierre = new Sound("./data/Yo_Pierre.wav");
            compilation.addSound(pierre);
            compilationDisplay.setBackground(Color.GREEN);
            songAdded.setText("Added: Yo Pierre you out here?");
            listDisplay.addSong("Yo Pierre...");

        }
    }

    // Represents a listener for a button
    private class TurboSoundAdderAction extends AbstractAction {

        // Modifies: this
        // Effects: Initializes action Listener with an ImageIcon
        TurboSoundAdderAction() {
            ImageIcon icon = new ImageIcon("./data/gunna.png");
            this.putValue(Action.SMALL_ICON, icon);

        }

        // Modifies: ListDisplay, SongAdderGUI
        // Effects: Adds song to the compilation, change text display to most recent
        //          song added and update ListDisplay with most recent song added
        @Override
        public void actionPerformed(ActionEvent e) {
            Sound turbo = new Sound("./data/Turbo.wav");
            compilation.addSound(turbo);
            compilationDisplay.setBackground(Color.GREEN);
            songAdded.setText("Added: Run it back turbo");
            listDisplay.addSong("Run it Back Turbo");


        }
    }

    // Represents a listener for a button
    private class UuuSoundAdderAction extends AbstractAction {

        // Modifies: this
        // Effects: Initializes action Listener with an ImageIcon
        UuuSoundAdderAction() {
            ImageIcon icon = new ImageIcon("./data/soulja.png");
            this.putValue(Action.SMALL_ICON, icon);
        }

        // Modifies: ListDisplay, SongAdderGUI
        // Effects: Adds song to the compilation, change text display to most recent
        //          song added and update ListDisplay with most recent song added
        @Override
        public void actionPerformed(ActionEvent e) {
            Sound uuu = new Sound("./data/UUU.wav");
            compilation.addSound(uuu);
            compilationDisplay.setBackground(Color.GREEN);
            songAdded.setText("Added: UUU!!!");
            listDisplay.addSong("UUU");

        }
    }

    // Represents a listener for a button
    private class DamnSoundAdderAction extends AbstractAction {

        // Modifies: this
        // Effects: Initializes action Listener with an ImageIcon
        DamnSoundAdderAction() {
            ImageIcon icon = new ImageIcon("./data/Damn.jpg");
            this.putValue(Action.SMALL_ICON, icon);

        }

        // Modifies: ListDisplay, SongAdderGUI
        // Effects: Adds song to the compilation, change text display to most recent
        //          song added and update ListDisplay with most recent song added
        @Override
        public void actionPerformed(ActionEvent e) {
            Sound damn = new Sound("./data/Damn_son.wav");
            compilation.addSound(damn);
            compilationDisplay.setBackground(Color.GREEN);
            songAdded.setText("Added: Damn son where'd you find that?");
            listDisplay.addSong("Damn son where'd you find that?");
        }
    }

    // Represents a listener for a button
    private class PlayCompilation extends AbstractAction {

        // Effects: initializes action listener with a title
        PlayCompilation() {
            super("Play compilation");
        }

        // Modifies: SongAdderGUI, ListDisplay
        // Effects: Play the songs added to the compilation display, clears list display,
        //          and clears text display
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Sound> sounds = compilation.getList();
            if (compilation.soundsEmpty()) {
                System.out.println("No sounds added to compilation");
            } else {
                for (int i = 0; i < sounds.size(); i++) {
                    sounds.get(i).playMusic();
                }
            }
            compilation.getList().clear();
            compilationDisplay.setBackground(Color.RED);
            songAdded.setText("Compilation is empty");
            listDisplay.clearList();


        }

    }

    // Represents a listener for a button
    private class SaveComp extends AbstractAction {

        //Effects: initializes an action listener with a title
        SaveComp() {
            super("Save");
        }

        // Modifies: SongAdderGUI
        // Effects: Saves compilations and display that compilation was saved in the Text Display
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                jsonWriter.open();
                jsonWriter.write(compilation);
                jsonWriter.close();
                compilationDisplay.setBackground(Color.GREEN);
                songAdded.setText("Saved");

            } catch (FileNotFoundException ex) {
                compilationDisplay.setBackground(Color.red);
                songAdded.setText("Failed to save");
            }

        }
    }

    // Represents a listener for a button
    private class LoadComp extends AbstractAction {

        //Effects: initializes action listener with a title
        LoadComp() {
            super("Load");
        }

        // Modifies: SongAdderGUI
        // Effects: Loads compilation, and displays where compilation was loaded from
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                compilation = jsonReader.read();
                compilationDisplay.setBackground(Color.GREEN);
                songAdded.setText("Loaded compilation from: " + JSON_STORE);
            } catch (IOException x) {
                songAdded.setText("Unable to read from file: " + JSON_STORE);
                compilationDisplay.setBackground(Color.red);
            }
        }
    }


}
