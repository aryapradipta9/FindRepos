package view;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/8/2017.
 * FileName : SearchCriteria.java.
 */
public class SearchCriteria extends JPanel {
  private JRadioButton fullname;
  private JRadioButton email;

  /**
   * Konstruktor SearchCriteria.
   * Melakukan pengesetan layout dari panel
   */
  public SearchCriteria() {
    super(new GridLayout(1,3));
    JRadioButton username = new JRadioButton("username");
    username.setSelected(true);
    fullname = new JRadioButton("fullname");
    email = new JRadioButton("email");
    ButtonGroup group = new ButtonGroup();
    group.add(username);
    group.add(fullname);
    group.add(email);
    add(username);
    add(fullname);
    add(email);
  }

  /**
   * Fungsi getSelectedid memilih manakah tombol radiobutton yang sedang aktif.
   * @return 0:login, 1:fullname, 2:email
   */
  public int getSelectedid() {
    if (fullname.isSelected()) {
      return 1;
    } else if (email.isSelected()) {
      return 2;
    } else {
      return 0;
    }
  }
}
