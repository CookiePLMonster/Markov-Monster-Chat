package gui;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 * Created by Adrian on 2015-06-06.
 */
public class GUIFormat {
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
}
