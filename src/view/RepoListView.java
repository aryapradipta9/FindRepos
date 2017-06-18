package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import model.Repo;

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
  private JLabel username;
  private JLabel numRepos;

  public JTable getTable() {
    return table;
  }

  public RepoListView() {
    super(new BorderLayout());
    scrollPane = new JScrollPane(table);
    JPanel headerPanel = new JPanel(new GridLayout(2,2));
    JPanel head1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    head1.add(new JLabel("Current Username : "));
    username = new JLabel("");
    head1.add(username);
    JPanel head2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    head2.add(new JLabel("Number of repos : "));
    numRepos = new JLabel("");
    head2.add(numRepos);
    headerPanel.add(head1);
    headerPanel.add(new JLabel(""));
    headerPanel.add(head2);
    add(headerPanel,BorderLayout.PAGE_START);
    add(scrollPane,BorderLayout.CENTER);
    Repo[] test = new Repo[1];
    test[0] = new Repo();
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

  public void setUsername(String username) {
    this.username.setText(username);
  }

  public void setNumRepos(int numRepos) {
    this.numRepos.setText(numRepos + "");
  }
}
