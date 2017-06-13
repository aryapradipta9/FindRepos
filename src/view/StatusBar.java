package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/13/2017.
 * FileName : StatusBar.java.
 */
public class StatusBar extends JPanel {
  private JLabel repoRequest;
  private JLabel userRequest;
  public StatusBar() {
    super(new FlowLayout());
    repoRequest = new JLabel();
    userRequest = new JLabel();
    add(new JLabel("Search request remaining : "));
    add(userRequest);
    add(new JLabel("Repo request remaining : "));
    add(repoRequest);
  }

  public JLabel getRepoRequest() {
    return repoRequest;
  }

  public void setRepoRequest(int repoRequest) {
    this.repoRequest.setText(repoRequest + "");
  }

  public JLabel getUserRequest() {
    return userRequest;
  }

  public void setUserRequest(int userRequest) {
    this.userRequest.setText(userRequest + "");
  }
}
