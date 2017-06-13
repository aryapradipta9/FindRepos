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

  public DriverModel() {
    repoListConn = new RepoListConn();
    userListConn = new UserListConn();
  }

  public RepoListConn getRepoListConn() {
    return repoListConn;
  }

  public UserListConn getUserListConn() {
    return userListConn;
  }

  public RemainingReq getRemainingReq() {
    return remainingReq;
  }
}
