package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/10/2017.
 * FileName : MenuBar.java.
 */
public class MenuBar extends JMenuBar {

  private JMenuItem pref;
  private JMenuItem exit;
  /**
   * Konstruktor MenuBar.
   */
  public MenuBar() {
    super();
    JMenu menu = new JMenu("File");
    add(menu);
    pref = new JMenuItem("Preferences");
    menu.add(pref);
    menu.addSeparator();
    exit = new JMenuItem("Exit");
    menu.add(exit);
  }

  /**
   * Getter Pref.
   * @return JMenuItem pref
   */
  public JMenuItem getPref() {
    return pref;
  }

  /**
   * Getter Exit.
   * @return JMenuItem exit
   */
  public JMenuItem getExit() {
    return exit;
  }
}
