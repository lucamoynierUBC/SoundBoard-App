package ui;

import model.Sound;
import model.SoundList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

// Sound board applications
public class SoundBoardApp {

    private Sound pierre;
    private Sound turbo;
    private Sound damnSon;
    private SoundList compilation;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/workroom.json";

    // EFFECTS: runs the sound board application
    public SoundBoardApp() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runSoundBoard();
    }


    // MODIFIES: this
    // EFFECTS: processes user input
    private void runSoundBoard() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("z")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nSound Board going to bed");
    }

    // MODIFIES: this
    // EFFECTS: initializes sounds and sound list
    private void init() {
        pierre = new Sound("./data/Yo_Pierre.wav");
        turbo = new Sound("./data/Turbo.wav");
        damnSon = new Sound("./data/Damn_son.wav");
        compilation = new SoundList();
        input = new Scanner(System.in);
        input.useDelimiter("\n");

    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("p")) {
            playPierre();
        } else if (command.equals("t")) {
            playTurbo();
        } else if (command.equals("d")) {
            playDamnSon();
        } else if (command.equals("a")) {
            makeCompilation();
        } else if (command.equals("c")) {
            playCompilation();
        } else if (command.equals("n")) {
            mostPlayed();
        } else if (command.equals("s")) {
            saveSoundList();
        } else if (command.equals("l")) {
            loadSoundList();
        } else {
            System.out.println("You miss-clicked a key :/");
        }
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nOptions:");
        System.out.println("\tp -> Yo Pierre you out here");
        System.out.println("\tt -> Run it back turbo");
        System.out.println("\td -> Damn son whered you find that");
        System.out.println("\ta -> make sound compilation");
        System.out.println("\tc -> play sound compilation");
        System.out.println("\tn -> most played sound");
        System.out.println("\ts -> save compilation");
        System.out.println("\tl -> load compilation");
        System.out.println("\tz -> exit");

    }

    // MODIFIES: this
    // EFFECTS: plays Pierre sound
    private void playPierre() {
        pierre.playMusic();


    }

    // MODIFIES: this
    // EFFECTS: plays Turbo sound
    private void playTurbo() {
        turbo.playMusic();

    }

    // MODIFIES: this
    // EFFECTS: plays Damn son sound
    private void playDamnSon() {
        damnSon.playMusic();

    }

    // EFFECTS: prints out most played song in a session
    private void mostPlayed() {
        if (damnSon.getNumPlays() > turbo.getNumPlays()
                && damnSon.getNumPlays() > pierre.getNumPlays()) {
            System.out.println("Most played sound: Damn son where'd you find that - "
                    + damnSon.getNumPlays());
        } else if (turbo.getNumPlays() > pierre.getNumPlays()) {
            System.out.println("Most played sound: Run it back turbo -"
                    + turbo.getNumPlays());
        } else {
            System.out.println("Most played sound: Yo Pierre you out here -"
                    + pierre.getNumPlays());
        }


    }

    // MODIFIES this
    // EFFECTS: adds songs to a list of songs
    private void makeCompilation() {
        String selection = "";

        while (!(selection.equals("p") || selection.equals("t")
                || selection.equals("d"))) {
            System.out.println("p to add Yo Pierre you out here");
            System.out.println("t to add Run it back turbo");
            System.out.println("d to add damn son where'd you find that");
            selection = input.next();
            selection = selection.toLowerCase();
        }
        if (selection.equals("p")) {
            compilation.addSound(pierre);
        } else if (selection.equals("t")) {
            compilation.addSound(turbo);
        } else if (selection.equals("d")) {
            compilation.addSound(damnSon);
        } else {
            System.out.println("Selection not valid");
        }
    }

    // EFFECTS: plays the list of songs one by one, after played clears the compilation
    private void playCompilation() {
        List<Sound> sounds = compilation.getList();
        if (compilation.soundsEmpty()) {
            System.out.println("No sounds added to compilation");
        } else {
            for (int i = 0; i < sounds.size(); i++) {
                sounds.get(i).playMusic();
            }
        }
        compilation.getList().clear();
    }

    // EFFECTS: saves soundlist to file
    private void saveSoundList() {
        try {
            jsonWriter.open();
            jsonWriter.write(compilation);
            jsonWriter.close();
            System.out.println("saved compilation");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write file");
        }
    }

    // MODIFIES: THIS
    // EFFECTS: loads soundlist from file
    private void loadSoundList() {
        try {
            compilation = jsonReader.read();
            System.out.println("Loaded compilation from" + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


}
