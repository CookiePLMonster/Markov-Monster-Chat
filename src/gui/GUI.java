package gui;

import monster.MarkovMonster;
import monster.Monster;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

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
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setJMenuBar(new TopBar().getMenuBar());
        frame.pack();
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String  opcje[] = { "Tak", "Nie", "Wróć" };

                int result = JOptionPane.showOptionDialog(null,
                        "Czy chcesz zapisać słownik przed wyjściem?", "Markov Monster Chat",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        opcje, opcje[0]);

                switch ( result )
                {
                    case 0:
                        File file = GUILogic.exportDialog();

                        if ( file != null ) {
                            markovMonster.generateTextFile(file);
                            System.out.println("Finished writing file!"); // Debug
                        }

                    case 1:
                        System.exit(0);
                        break;
                }
            }
        });
    }
}
