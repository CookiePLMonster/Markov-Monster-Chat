package UI;

import javax.swing.*;

/**
 * Created by Adrian on 2015-05-04.
 */
public class GUI {
    private JButton wyślijButton;
    private JPanel GUI;
    private JTextPane xXxXxJaTextPane;
    private JTextField nGramówWPamięciTextField;
    private JButton zobaczSłownikButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Markov Monster Chat");
        frame.setContentPane(new GUI().GUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(new TopBar().getMenuBar());
        frame.pack();
        frame.setVisible(true);
    }
}
