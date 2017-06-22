package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


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


  /**
   * Kostrutktor Driverview.
   * Menginstantiasi semua objek di dalamnya.
   */
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

  /**
   * Getter RepoListView.
   * @return RepoListView yang digunakan
   */
  public RepoListView getRepo() {
    return repo;
  }

  /**
   * Getter UserListView.
   * @return UserListView yang digunakan
   */
  public UserListView getUser() {
    return user;
  }

  /**
   * Getter SearchFilter.
   * @return SearchFilter yang digunakan
   */
  public SearchFilter getSearchFilter() {
    return searchFilter;
  }

  /**
   * Getter SearchBox.
   * @return SearchBox yang digunakan
   */
  public SearchBox getSearchBox() {
    return searchBox;
  }

  /**
   * Getter SearchCriteria.
   * @return SearchCriteria yang digunakan
   */
  public SearchCriteria getSearchCriteria() {
    return searchCriteria;
  }

  /**
   * Getter SignView.
   * @return SignView yang digunakan
   */
  public SignView getSignView() {
    return signView;
  }

  /**
   * Getter MenuBar.
   * @return MenuBar yang digunakan
   */
  public MenuBar getMenuBar() {
    return menuBar;
  }

  /**
   * Getter StatusBar.
   * @return StatusBar yang digunakan
   */
  public StatusBar getStatusBar() {
    return statusBar;
  }

  /**
   * Getter Frame.
   * @return Frame yang digunakan
   */
  public JFrame getFrame() {
    return frame;
  }
}
