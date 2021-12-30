package ui;

import model.Event;
import model.EventLog;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PrintToConsole implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {
    }

    public void printLog(EventLog el) {
        for (Event next: el) {
            System.out.println(next.toString());
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        printLog(EventLog.getInstance());
        System.out.println("closed");

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
