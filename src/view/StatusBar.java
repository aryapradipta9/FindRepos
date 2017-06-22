package view;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/13/2017.
 * FileName : StatusBar.java.
 */
public class StatusBar extends JPanel {
  private JLabel repoRequest;
  private JLabel userRequest;
  private JLabel connStatus;

  /**
   * Konstruktor StatusBar.
   */
  public StatusBar() {
    super(new FlowLayout());
    repoRequest = new JLabel();
    userRequest = new JLabel();
    connStatus = new JLabel();
    add(new JLabel("Search request remaining : "));
    add(userRequest);
    add(new JLabel("Repo request remaining : "));
    add(repoRequest);
    add(connStatus);

  }

  /**
   * Setter RepoRequest.
   * @param repoRequest integer remaining RepoRequest
   */
  public void setRepoRequest(int repoRequest) {
    this.repoRequest.setText(repoRequest + "");
  }

  /**
   * Setter UserRequest.
   * @param userRequest integer remaining UserRequest
   */
  public void setUserRequest(int userRequest) {
    this.userRequest.setText(userRequest + "");
  }

  /**
   * Setter ConnStatus.
   * @param isOnline apakah status online atau tidak
   */
  public void setConnStatus(boolean isOnline) {
    if (isOnline) {
      connStatus.setText("You are online");
    } else {
      connStatus.setText("You are offline");
    }
  }
}
