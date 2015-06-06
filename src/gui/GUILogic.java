package gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.io.File;

/**
 * Created by Adrian on 2015-06-06.
 */
public class GUILogic {
    public static void putUserLine(JEditorPane where, String line)
    {
        Document doc = where.getDocument();
        try {
            doc.insertString(doc.getLength(), line  + "\n", null);
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }

    public static void putBotLine(JEditorPane where, String line)
    {
        Document doc = where.getDocument();
        try {
            doc.insertString(doc.getLength(), line  + "\n", null);
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
}
