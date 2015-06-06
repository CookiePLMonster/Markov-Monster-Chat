package gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.io.File;
import java.util.Calendar;

/**
 * Created by Adrian on 2015-06-06.
 */
public class GUILogic {
    public static void putUserLine(JEditorPane where, String line)
    {
        Document doc = where.getDocument();
        try {
            doc.insertString(doc.getLength(),
                    getTimeStamp() + " Ja: " + line  + "\n", null);
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }

    public static void putBotLine(JEditorPane where, String line)
    {
        Document doc = where.getDocument();
        try {
            doc.insertString(doc.getLength(),
                    getTimeStamp() + " Monster: " + line  + "\n", null);
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }

    public static File importDialog()
    {
        JFileChooser chooser = new JFileChooser();

        chooser.setFileFilter( new FileNameExtensionFilter(
                "Pliki tekstowe (TXT)", "txt"));

        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }

        return null;
    }

    public static File exportDialog()
    {
        JFileChooser chooser = new JFileChooser();

        chooser.setFileFilter( new FileNameExtensionFilter(
                "Pliki tekstowe (TXT)", "txt"));

        int returnVal = chooser.showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }

        return null;
    }

    private static String getTimeStamp()
    {
        Calendar rightNow = Calendar.getInstance();

        return "(" + String.format("%02d", rightNow.get(Calendar.HOUR_OF_DAY)) +
                ":" + String.format("%02d", rightNow.get(Calendar.MINUTE)) +
                ":" + String.format("%02d", rightNow.get(Calendar.SECOND)) + ")";
    }
}
