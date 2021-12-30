package ui;

import model.Event;
import model.EventLog;
import ui.buttons.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// Sound GUI
public class SoundGUI extends JFrame {
    private JDesktopPane desktop;
    private DamnButton damnButton;
    private PierreButton pierreButton;
    private TurboButton turboButton;
    private UuuButton uuuButton;
    private JInternalFrame soundBoard;
    private BigButton cui;
    private SongAdderGUI sgui;
    private BeatPlayerGUI bui;

    // Effects: Initializes the SoundGui and its components
    public SoundGUI() {
        desktop = new JDesktopPane();
        setContentPane(desktop);
        setSize(1000, 1000);
        setTitle("swag");

        soundBoard = new JInternalFrame("Sound Board", false, false, false, false);
        soundBoard.setLayout(new BorderLayout());
        soundBoard.setVisible(true);
        soundBoard.pack();
        soundBoard.setSize(500, 500);

        desktop.add(soundBoard);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        initializeSounds();

        addCompilationUI();
        addBeatPlayerGUI();

        PrintToConsole ptc = new PrintToConsole();
        this.addWindowListener(ptc);




    }

    // Modifies: this
    // Effects: adds sound buttons to the SoundGUI
    public void initializeSounds() {
        damnButton = new DamnButton();
        pierreButton = new PierreButton();
        turboButton = new TurboButton();
        uuuButton = new UuuButton();


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));
        buttonPanel.add(damnButton);
        buttonPanel.add(uuuButton);
        buttonPanel.add(turboButton);
        buttonPanel.add(pierreButton);

        soundBoard.add(buttonPanel);
    }

    // Modifies: this
    // Effects: adds a big button with a Listener to the SoundGUI
    public void addCompilationUI() {
        cui = new BigButton(this);
        JButton clickMe = new ButtonComp(new DeletePanelAction());
        clickMe.setText("Click Me");
        cui.add(clickMe);
        desktop.add(cui);


    }

    // Modifies: this
    // Effects: adds BeatPlayerGUi to SoundGUI
    public void addBeatPlayerGUI() {
        bui = new BeatPlayerGUI(this);
        desktop.add(bui);
    }

    // Represents an Action Listener to delete JPanels
    private class DeletePanelAction extends AbstractAction {

        // Effects: deletes the big button and its place adds the SongAdderGUI
        @Override
        public void actionPerformed(ActionEvent e) {
            cui.dispose();
            sgui = new SongAdderGUI(desktop);
            desktop.add((sgui));


        }
    }

    public void printLog(EventLog el) {
        for (Event next: el) {
            System.out.println(next.toString());
        }
    }





    // Effects: Runs SoundGUI
    public static void main(String[] args) {

        new SoundGUI();



    }

}





