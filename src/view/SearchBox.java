package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/7/2017.
 * FileName : SearchBox.java.
 */
public class SearchBox extends JPanel {
  private JTextField textField;
  private JButton button;

  /**
   * Konstruktor SearchBox.
   */
  public SearchBox() {
    super(new BorderLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.BOTH;
    c.weighty = 0.5;
    c.weightx = 0.5;
    c.gridx = 0;
    c.gridy = 0;
    c.ipadx = 5;
    c.gridwidth = 5;
    textField = new JTextField();
    button = new JButton("SEARCH");
    add(textField,BorderLayout.CENTER);
    c.gridwidth = 1;
    c.ipadx = 0;
    c.gridx = 5;
    add(button,BorderLayout.LINE_END);
    textField.setText("");
  }

  /**
   * Getter text Content.
   * @return mengambil isi dari teks dalam textbox nya
   */
  public String getTextContent() {
    return textField.getText();
  }

  /**
   * Getter Button search.
   * @return JButton dari tombol tersebut
   */
  public JButton getButton() {
    return button;
  }
}
