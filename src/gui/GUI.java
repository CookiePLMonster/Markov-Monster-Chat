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
    private JButton zobaczSłownikButton;
    private JTextArea textArea1;

    static JFrame frame = new JFrame("Markov Monster Chat");

    static final Monster markovMonster = new MarkovMonster();

    public GUI() {
        wyślijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textArea1.getText()); // Debug
                markovMonster.readChatLine(textArea1.getText());
                GUILogic.putUserLine(xXxXxJaTextPane, textArea1.getText());

                textArea1.setText(null);

                // Odpowiedź
                // TODO: ładniej?
                String  response = markovMonster.generateChatLine();
                GUILogic.putBotLine(xXxXxJaTextPane, response);

                // Niech bot uczy się też z własnych odpowiedzi
                // Dzięki temu załapie to, co użytkownik mu odpisuje
                markovMonster.readChatLine(response);
            }
        });
        zobaczSłownikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame      statFrame = new JFrame("Statystyki");

                statFrame.setContentPane(new Stats().STAT);
                statFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                statFrame.pack();
                statFrame.setVisible(true);


            }
        });
    }

    public static void main(String[] args) {
        frame.setContentPane(new GUI().GUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(new TopBar().getMenuBar());
        frame.pack();
        frame.setVisible(true);
    }
}
