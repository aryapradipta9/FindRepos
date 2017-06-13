package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/13/2017.
 * FileName : SignView.java.
 */
public class SignView extends JPanel {
  private JLabel copyright;
  private JLabel logo;

  public SignView() {
    super();
    setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    setAlignmentX(Component.LEFT_ALIGNMENT);
    JPanel tempPanel = new JPanel(new FlowLayout());
    try {
      Image img = ImageIO.read(getClass().getResource("../assets/logo.png"));
      ImageIcon temp = new ImageIcon(img);
      logo = new JLabel(temp);
    } catch (IOException e) {
      e.printStackTrace();
    }
    copyright = new JLabel("Made by Arya Pradipta");
    //tempPanel.add(logo);
    //tempPanel.add(new JLabel("a github search engine"));
    add(logo);
    add(copyright);

  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("SimpleTableDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Create and set up the content pane.
    SignView newContentPane = new SignView();
    newContentPane.setOpaque(true); //content panes must be opaque
    frame.setContentPane(newContentPane);

    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }
}
