package model;

import com.google.gson.Gson;

import java.io.IOException;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/3/2017.
 * FileName : RepoListConn.java.
 */
public class RepoListConn {
  private String username;
  private Repo[] repoList;
  private int numRepos;

  /**
   * Konstruktor RepoListConn.
   * Mengeset numRepos ke 0
   */
  public RepoListConn() {
    numRepos = 0;
  }

  /**
   * Setter usename.
   * @param username string username yang akan dicari
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Getter RepoList.
   * @return Array of Repo yang merupakan hasil pencarian terakhir
   */
  public Repo[] getRepoList() {
    return repoList;
  }

  /**
   * Fungsi search.
   * Melakukan request search repository pada github api dan memasukannya pada array repoList.
   * @throws IOException jika tidak terdapat koneksi internet
   */
  public void search() throws IOException {
    GetConn connection;
    connection = new GetConn("https://api.github.com/users/" + username + "/repos");
    Gson gson = new Gson();
    repoList = gson.fromJson(connection.getResponse().toString(),Repo[].class);
    numRepos = repoList.length;

  }

  /**
   * Getter username.
   * @return String username terakhir yang dicari
   */
  public String getUsername() {
    return username;
  }

  /**
   * Getter NumRepos.
   * @return integer jumlah numRepos hasil pencarian
   */
  public int getNumRepos() {
    return numRepos;
  }
}
