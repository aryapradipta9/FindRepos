package view;

import java.awt.Component;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/13/2017.
 * FileName : SignView.java.
 */
public class SignView extends JPanel {
  private JLabel copyright;
  private JLabel logo;

  /**
   * Konstruktor SignView.
   */
  public SignView() {
    super();
    setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    setAlignmentX(Component.LEFT_ALIGNMENT);
    try {
      Image img = ImageIO.read(getClass().getResource("../assets/logo.png"));
      ImageIcon temp = new ImageIcon(img);
      logo = new JLabel(temp);
    } catch (IOException e) {
      e.printStackTrace();
    }
    copyright = new JLabel("Made by Arya Pradipta");
    add(logo);
    add(copyright);

  }


}
