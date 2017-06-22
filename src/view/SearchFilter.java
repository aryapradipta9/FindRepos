package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/9/2017.
 * FileName : SearchFilter.java.
 */
public class SearchFilter extends JPanel {
  private JCheckBox follower;
  private JCheckBox repository;
  private JTextField maxfollower;
  private JTextField maxrepository;
  private JTextField minfollower;
  private JTextField minrepository;

  /**
   * Konstruktor SearchFilter.
   */
  public SearchFilter() {
    super(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.BOTH;
    c.weightx = 0.5;
    c.weighty = 0.5;
    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 2;
    follower = new JCheckBox("Follower");
    add(follower,c);
    c.gridx = 2;
    repository = new JCheckBox("Repository");
    add(repository,c);
    c.gridx = 0;
    c.gridy = 1;
    c.gridwidth = 1;
    minfollower = new JTextField("0");
    add(minfollower,c);
    c.gridx = 1;
    maxfollower = new JTextField("1000000");
    add(maxfollower,c);
    c.gridx = 2;
    minrepository = new JTextField("0");
    add(minrepository,c);
    c.gridx = 3;
    maxrepository = new JTextField("100000");
    add(maxrepository,c);
  }

  /**
   * Getter Checkbox Follower.
   * @return JCheckBox Follower
   */
  public JCheckBox getFollower() {
    return follower;
  }

  /**
   * Getter CheckBox Repository.
   * @return JCheckBox repo
   */
  public JCheckBox getRepository() {
    return repository;
  }

  /**
   * Getter MaxFollower.
   * @return angka maksimal follower
   */
  public JTextField getMaxfollower() {
    return maxfollower;
  }

  /**
   * Getter MaxRepository.
   * @return angka maksimal repository
   */
  public JTextField getMaxrepository() {
    return maxrepository;
  }

  /**
   * Getter MinFollower.
   * @return angka minimal follower
   */
  public JTextField getMinfollower() {
    return minfollower;
  }

  /**
   * Getter MinRepository.
   * @return angka minimal repo
   */
  public JTextField getMinrepository() {
    return minrepository;
  }
}
