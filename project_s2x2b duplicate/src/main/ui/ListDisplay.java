package ui;

import javax.swing.*;

// Represents a display that displays a list
public class ListDisplay extends JPanel {
    private JList<String> list;
    private DefaultListModel<String> dlm;
    private JScrollPane pane;

    // Effects: Initializes a list display, adds a scroll pane to display
    public ListDisplay() {
        list = new JList<>();
        dlm = new DefaultListModel<>();
        pane = new JScrollPane(list);
        list.setModel(dlm);
        this.add(pane);
    }

    // Modifies: this
    // Effects: adds a song to the list in the list display
    public void addSong(String song) {
        dlm.addElement(song);
    }

    // Modifies: this
    // Effects: clears the list in the list display
    public void clearList() {
        dlm.clear();
    }


}
