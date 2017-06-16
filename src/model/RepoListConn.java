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

  public RepoListConn() {
    numRepos = 0;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Repo[] getRepoList() {
    return repoList;
  }

  /**
   * Fungsi search.
   * Melakukan request search repository pada github api dan memasukannya pada array repoList.
   */
  public void search() throws IOException {
    GetConn connection;
    connection = new GetConn("https://api.github.com/users/" + username + "/repos");
    Gson gson = new Gson();
    repoList = gson.fromJson(connection.getResponse().toString(),Repo[].class);
    numRepos = repoList.length;

  }

  public String getUsername() {
    return username;
  }

  public int getNumRepos() {
    return numRepos;
  }
}
