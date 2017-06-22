package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/4/2017.
 * FileName : UserListView.java.
 */
public class UserListView extends JPanel {
  private final Object[] header = {"Username"};
  private JTable table;
  private JScrollPane scrollPane;

  /**
   * Konstruktor UserListView.
   */
  public UserListView() {
    super(new GridLayout(1,0));
    scrollPane = new JScrollPane();
    add(scrollPane);
  }

  /**
   * Update tabel dan data.
   * @param result Array of Object dari data username
   */
  public void update(Object[] result) {
    Object[][] temp = new Object[result.length][1];
    for (int i = 0; i < result.length; i++) {
      temp[i][0] = result[i];
    }
    table = new JTable(temp, header);
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));
    table.setFillsViewportHeight(true);
    scrollPane.setViewportView(table);
  }

  /**
   * Getter Tabel.
   * @return tabel yang terkandung
   */
  public JTable getTable() {
    return table;
  }
}
