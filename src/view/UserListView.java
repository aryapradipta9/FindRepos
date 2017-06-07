package view;

import model.UserListConn;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/4/2017.
 * FileName : UserListView.java.
 */
public class UserListView extends JPanel {
  private final Object[] header = {"Username"};
  private Object[][] temp;
  private JTable table;

  public JTable getTable() {
    return table;
  }

  public UserListView() {
    super(new GridLayout(1,0));
  }

  public void update(Object[] result) {
    Object[][] temp = new Object[result.length][1];
    for (int i = 0; i < result.length; i++) {
      temp[i][0] = result[i];
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
    UserListConn testing = new UserListConn();
    testing.setFollower(true);
    //testing.setKeyword("");
    testing.searchByUsername();
    JFrame frame = new JFrame("SimpleTableDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Create and set up the content pane.
    UserListView newContentPane = new UserListView();
    newContentPane.update(testing.getUserLists().toArray());
    newContentPane.setOpaque(true); //content panes must be opaque
    frame.setContentPane(newContentPane);

    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }
}
