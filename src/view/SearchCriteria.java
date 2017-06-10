package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/8/2017.
 * FileName : SearchCriteria.java.
 */
public class SearchCriteria extends JPanel {
  private JRadioButton username;
  private JRadioButton fullname;
  private JRadioButton email;


  public SearchCriteria() {
    super(new GridLayout(1,3));
    username = new JRadioButton("username");
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
