package view;

import model.Repo;
import model.RepoListConn;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/4/2017.
 * FileName : RepoListView.java.
 */
public class RepoListView extends JPanel {

  private final Object[] header = {"Name",
      "Description",
      "URL"};
  private Object[][] temp;
  private JTable table;
  public RepoListView() {
    super(new GridLayout(1,0));
    // converting to Object[]
  }
  public void update(Repo[] result) {
    Object[][] temp = new Object[result.length][3];
    for (int i = 0; i < result.length; i++) {
      temp[i][0] = result[i].getName();
      temp[i][1] = result[i].getDescription();
      temp[i][2] = result[i].getHtml_url();
    }
    removeAll();
    table = new JTable(temp, header);
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));
    table.setFillsViewportHeight(true);
    //Create the scroll pane and add the table to it.
    JScrollPane scrollPane = new JScrollPane(table);
    //Add the scroll pane to this panel.
    add(scrollPane);
  }
  public static void main(String[] args) {
    RepoListConn testing = new RepoListConn();
    testing.setUsername("torvalds");
    testing.search();
    JFrame frame = new JFrame("SimpleTableDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Create and set up the content pane.
    RepoListView newContentPane = new RepoListView();
    newContentPane.update(testing.getRepoList());
    newContentPane.setOpaque(true); //content panes must be opaque
    frame.setContentPane(newContentPane);

    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }
}
