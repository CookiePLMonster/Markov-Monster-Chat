package UI;

import javax.swing.*;

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
