package view;

import javax.swing.*;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/10/2017.
 * FileName : MenuBar.java.
 */
public class MenuBar extends JMenuBar {
  public MenuBar() {
    super();
    JMenu menu = new JMenu("File");
    add(menu);
    JMenuItem about = new JMenu("About");
    menu.add(about);
    menu.addSeparator();
    JMenuItem exit = new JMenu("Exit");
    menu.add(exit);
  }
}