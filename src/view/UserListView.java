package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
  private JScrollPane scrollPane;
  private DefaultTableModel defaultTableModel;
  public JTable getTable() {
    return table;
  }

  public UserListView() {
    super(new GridLayout(1,0));
    scrollPane = new JScrollPane();
    add(scrollPane);
  }

  public void update(Object[] result) {
    Object[][] temp = new Object[result.length][1];
    for (int i = 0; i < result.length; i++) {
      temp[i][0] = result[i];
    }
    // removing all current data

    //removeAll();
    table = new JTable(temp, header);
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));
    table.setFillsViewportHeight(true);
    //Create the scroll pane and add the table to it.
    scrollPane.setViewportView(table);
    //Add the scroll pane to this panel.
    //add(table);
  }
}
