package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
        importItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = GUILogic.importDialog();

                if ( file != null ) {
                    GUI.markovMonster.readTextFile(file.getPath());
                    System.out.println("Finished reading file!"); // Debug
                }
            }
        });

        fileMenu.add(importItem);

        JMenuItem   exportItem = new JMenuItem("Eksportuj...");
        exportItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = GUILogic.exportDialog();

                if ( file != null ) {
                    GUI.markovMonster.generateTextFile(file);
                    System.out.println("Finished writing file!"); // Debug
                }
            }
        });


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
