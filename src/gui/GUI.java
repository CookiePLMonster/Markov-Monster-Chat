package gui;

import com.sun.javaws.exceptions.ExitException;
import monster.Monster;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Adrian on 2015-05-04.
 */
public class GUI {
    private JButton wyślijButton;
    private JPanel GUI;
    private JTextPane xXxXxJaTextPane;
    private JTextField nGramówWPamięciTextField;
    private JButton zobaczSłownikButton;
    private JTextArea textArea1;

    private final Monster markovMonster = new Monster();

    public GUI() {
        wyślijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textArea1.getText()); // Debug
                markovMonster.readChatLine(textArea1.getText());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Markov Monster Chat");
        frame.setContentPane(new GUI().GUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(new TopBar().getMenuBar());
        frame.pack();
        frame.setVisible(true);
    }
}
