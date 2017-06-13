package view;

import model.Repo;
import model.RepoListConn;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

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
  private JScrollPane scrollPane;

  public JTable getTable() {
    return table;
  }

  public RepoListView() {
    super(new GridLayout(1,0));
    scrollPane = new JScrollPane(table);
    add(scrollPane);
    Repo[] test = new Repo[1];
    test[0] = new Repo();
    test[0].setName("");
    test[0].setDescription("");
    update(test);
    // converting to Object[]
  }
  public void update(Repo[] result) {
    Object[][] temp = new Object[result.length][3];
    for (int i = 0; i < result.length; i++) {
      temp[i][0] = result[i].getName();
      temp[i][1] = result[i].getDescription();
      temp[i][2] = result[i].getHtml_url();
    }
    //removeAll();
    table = new JTable(temp, header);
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));
    table.setFillsViewportHeight(true);
    //Create the scroll pane and add the table to it.

    //Add the scroll pane to this panel.
    scrollPane.setViewportView(table);
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
