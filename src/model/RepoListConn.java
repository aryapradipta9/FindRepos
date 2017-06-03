package model;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/3/2017.
 * FileName : RepoListConn.java.
 */
public class RepoListConn {
  private String username;
  private Repo[] repoList;

  public RepoListConn() {
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Repo[] getRepoList() {
    return repoList;
  }

  public void search() {
    StringBuffer urlLink = new StringBuffer("https://api.github.com/users/" + username + "/repos");
    GetConn connection = new GetConn(urlLink.toString());
    Gson gson = new Gson();
    repoList = gson.fromJson(connection.getResponse().toString(),Repo[].class);
  }

  public static void main(String[] args) {
    RepoListConn testing = new RepoListConn();
    testing.setUsername("torvalds");
    testing.search();
    Repo[] result = testing.getRepoList();
    for (Repo temp : result) {
      System.out.println(temp.getName());
    }
  }
}
