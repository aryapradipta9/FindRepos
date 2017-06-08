package view;

import model.RepoListConn;
import model.UserListConn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/7/2017.
 * FileName : DriverView.java.
 */
public class DriverView {
  private RepoListView repo;
  private UserListView user;

  public DriverView() {
    repo = new RepoListView();
    user = new UserListView();
  }

  public RepoListView getRepo() {
    return repo;
  }

  public UserListView getUser() {
    return user;
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        UserListConn testing = new UserListConn();
        testing.setFollower(true);
        //testing.setKeyword("");
        testing.searchByUsername();
        //Create and set up the content pane.
        JPanel p = new JPanel(new GridLayout(2,2));
        RepoListView repo = new RepoListView();
        RepoListConn rp = new RepoListConn();
        UserListView user = new UserListView();
        p.add(user);
        p.add(repo);
        SearchBox searchBox = new SearchBox();
        p.add(searchBox);
        user.update(testing.getUserLists().toArray());
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(p);
        frame.pack();
        frame.setVisible(true);
        searchBox.getButton().addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            testing.setKeyword(searchBox.getTextContent());
            if (searchBox.getSearchCriteria().getSelectedid() == 0) {
              testing.searchByUsername();
            } else {
              testing.searchByEmail();
            }
            user.update(testing.getUserLists().toArray());
            frame.pack();
            user.getTable().addMouseListener(new MouseListener() {
              @Override
              public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                  final JTable target = (JTable)e.getSource();
                  final int row = target.getSelectedRow();
                  final int column = target.getSelectedColumn();
                  // Cast to ur Object type
                  final String urObjctInCell = (String)target.getValueAt(row, column);

                  rp.setUsername(urObjctInCell);
                  rp.search();
                  repo.update(rp.getRepoList());
                  frame.pack();
                  System.out.println(urObjctInCell);
                }

              }

              @Override
              public void mousePressed(MouseEvent e) {

              }

              @Override
              public void mouseReleased(MouseEvent e) {

              }

              @Override
              public void mouseEntered(MouseEvent e) {

              }

              @Override
              public void mouseExited(MouseEvent e) {

              }
            });
          }
        });
        user.getTable().addMouseListener(new MouseListener() {
          @Override
          public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) {
              final JTable target = (JTable)e.getSource();
              final int row = target.getSelectedRow();
              final int column = target.getSelectedColumn();
              // Cast to ur Object type
              final String urObjctInCell = (String)target.getValueAt(row, column);

              rp.setUsername(urObjctInCell);
              rp.search();
              repo.update(rp.getRepoList());
              frame.pack();
              System.out.println(urObjctInCell);
            }

          }

          @Override
          public void mousePressed(MouseEvent e) {

          }

          @Override
          public void mouseReleased(MouseEvent e) {

          }

          @Override
          public void mouseEntered(MouseEvent e) {

          }

          @Override
          public void mouseExited(MouseEvent e) {

          }
        });

      }
    });
  }
}