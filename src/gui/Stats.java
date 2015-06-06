package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Adrian on 2015-06-06.
 */
public class Stats {
    JPanel STAT;
    private JTextArea textArea1;

    public Stats() {
        textArea1.setText("Słów w pamięci: " + GUI.markovMonster.countWords() + "\n|"
                        + "n-gramów w pamięci: " + GUI.markovMonster.countGrams()       );
    }
}
