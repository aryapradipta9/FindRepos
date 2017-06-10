package view;

import model.RepoListConn;
import model.UserListConn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/7/2017.
 * FileName : DriverView.java.
 */
public class DriverView extends JPanel {
  private RepoListView repo;
  private UserListView user;

  public DriverView() {
    super(new GridLayout(2,2));
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
        //Create and set up the content pane.
        JPanel p = new JPanel(new GridLayout(2,2));
        RepoListView repo = new RepoListView();
        RepoListConn rp = new RepoListConn();
        UserListView user = new UserListView();
        p.add(user);
        p.add(repo);
        SearchBox searchBox = new SearchBox();
        p.add(searchBox);
        SearchFilter searchFilter = new SearchFilter();
        p.add(searchFilter);
        user.update(testing.getUserLists().toArray());
        //JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(p);
        frame.pack();
        frame.setVisible(true);

        frame.setJMenuBar(new MenuBar());
        searchBox.getButton().addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            try {
              testing.setKeyword(URLEncoder.encode(searchBox.getTextContent(),"UTF-8") );
            } catch (UnsupportedEncodingException e1) {
              e1.printStackTrace();
            }
            if (searchFilter.getFollower().isSelected()) {
              testing.setFollower(true);
              testing.setMinFollower(Integer.parseInt(searchFilter.getMinfollower().getText()));
              testing.setMaxFollower(Integer.parseInt(searchFilter.getMaxfollower().getText()));
            } else {
              testing.setFollower(false);
            }
            if (searchFilter.getRepository().isSelected()) {
              testing.setRepoNum(true);
              testing.setMinRepoNum(Integer.parseInt(searchFilter.getMinrepository().getText()));
              testing.setMaxRepoNum(Integer.parseInt(searchFilter.getMaxrepository().getText()));
            } else {
              testing.setRepoNum(false);
            }
            testing.search(searchBox.getSearchCriteria().getSelectedid());
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
