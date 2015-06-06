package gui;

import monster.MarkovMonster;
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
    private JEditorPane xXxXxJaTextPane;
    private JTextField nGramówWPamięciTextField;
    private JButton zobaczSłownikButton;
    private JTextArea textArea1;

    private final Monster markovMonster = new MarkovMonster();

    public GUI() {
        wyślijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textArea1.getText()); // Debug
                markovMonster.readChatLine(textArea1.getText());
                GUIFormat.putUserLine(xXxXxJaTextPane, textArea1.getText());

                textArea1.setText(null);

                // Odpowiedź
                // TODO: ładniej?
                String  response = markovMonster.generateChatLine();
                GUIFormat.putBotLine(xXxXxJaTextPane, response);

                // Niech bot uczy się też z własnych odpowiedzi
                // Dzięki temu załapie to, co użytkownik mu odpisuje
                markovMonster.readChatLine(response);
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
