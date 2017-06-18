package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/7/2017.
 * FileName : DriverView.java.
 */
public class DriverView {
  private RepoListView repo;
  private UserListView user;
  private SearchFilter searchFilter;
  private SearchBox searchBox;
  private SearchCriteria searchCriteria;
  private SignView signView;
  private MenuBar menuBar;
  private StatusBar statusBar;
  private JFrame frame;


  public DriverView() {
    repo = new RepoListView();
    user = new UserListView();
    searchBox = new SearchBox();
    searchFilter = new SearchFilter();
    searchCriteria = new SearchCriteria();
    signView = new SignView();
    statusBar = new StatusBar();
    JPanel search = new JPanel(new BorderLayout());
    search.add(searchBox,BorderLayout.PAGE_START);
    JPanel borderPanel = new JPanel(new BorderLayout());
    borderPanel.add(searchCriteria,BorderLayout.LINE_START);
    borderPanel.add(searchFilter,BorderLayout.CENTER);
    borderPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    search.add(borderPanel,BorderLayout.CENTER);
    JPanel header = new JPanel(new BorderLayout());
    header.add(signView,BorderLayout.LINE_START);
    header.add(search,BorderLayout.CENTER);
    JPanel p = new JPanel(new BorderLayout());
    p.add(user,BorderLayout.LINE_START);
    p.add(repo,BorderLayout.CENTER);
    p.add(header,BorderLayout.PAGE_START);
    p.add(statusBar,BorderLayout.PAGE_END);

    frame = new JFrame("FindRepos");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setContentPane(p);
    frame.pack();
    frame.setVisible(true);
    menuBar = new MenuBar();
    frame.setJMenuBar(menuBar);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
  }

  public RepoListView getRepo() {
    return repo;
  }

  public UserListView getUser() {
    return user;
  }

  public SearchFilter getSearchFilter() {
    return searchFilter;
  }

  public SearchBox getSearchBox() {
    return searchBox;
  }

  public SearchCriteria getSearchCriteria() {
    return searchCriteria;
  }

  public SignView getSignView() {
    return signView;
  }

  public MenuBar getMenuBar() {
    return menuBar;
  }

  public StatusBar getStatusBar() {
    return statusBar;
  }

  public JFrame getFrame() {
    return frame;
  }
}
