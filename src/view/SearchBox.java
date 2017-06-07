package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/7/2017.
 * FileName : SearchBox.java.
 */
public class SearchBox extends JPanel {
  private JTextField textField;
  private JButton button;
  public SearchBox() {
    super(new GridLayout(1,2));
    textField = new JTextField();
    button = new JButton("SEARCH");
    add(textField);
    add(button);
  }

  public String getTextContent() {
    return textField.getText();
  }

  public JButton getButton() {
    return button;
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    SearchBox cont = new SearchBox();
    JPanel panel = new JPanel(new GridLayout(2,1));
    panel.add(cont);
    JLabel label = new JLabel("DEF");
    panel.add(label);
    frame.add(panel);
    cont.getButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        label.setText(cont.getTextContent());
        frame.pack();
      }
    });
    frame.pack();
    frame.setVisible(true);

  }
}
