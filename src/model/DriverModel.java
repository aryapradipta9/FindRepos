package model;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/13/2017.
 * FileName : DriverModel.java.
 */
public class DriverModel {
  private RepoListConn repoListConn;
  private UserListConn userListConn;
  private RemainingReq remainingReq;

  /**
   * Konstruktor DriverModel.
   * Membuat 3 kelas yang berinteraksi dengan view.
   */
  public DriverModel() {
    repoListConn = new RepoListConn();
    userListConn = new UserListConn();
    remainingReq = new RemainingReq();
  }

  /**
   * Getter RepoListConn.
   * @return repoListConn yang terpasang
   */
  public RepoListConn getRepoListConn() {
    return repoListConn;
  }

  /**
   * Getter UserListConn.
   * @return userListConn yang terpasang
   */
  public UserListConn getUserListConn() {
    return userListConn;
  }

  /**
   * Getter RemainingReq.
   * @return remainingReq yang terpasang
   */
  public RemainingReq getRemainingReq() {
    return remainingReq;
  }
}
