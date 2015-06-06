package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Adrian on 2015-05-04.
 */
public class TopBar {
    private JMenuBar    menuBar = new JMenuBar();


    public TopBar()
    {
        JMenu       fileMenu = new JMenu("Plik");
        menuBar.add(fileMenu);

        JMenuItem   importItem = new JMenuItem("Importuj...");
        fileMenu.add(importItem);

        JMenuItem   exportItem = new JMenuItem("Eksportuj...");
        fileMenu.add(exportItem);

        fileMenu.add(new JSeparator());

        JMenuItem   quitItem = new JMenuItem("Wyjdź...");
        quitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Program terminated on request");
                System.exit(0);
            }
        });
        fileMenu.add(quitItem);


        JMenu       sets = new JMenu("Ustawienia");
        menuBar.add(sets);

        JMenuItem   gram = new JMenuItem("Długość n-gramu...");
        sets.add(gram);


        JMenu       halp = new JMenu("Pomoc");
        menuBar.add(halp);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}
