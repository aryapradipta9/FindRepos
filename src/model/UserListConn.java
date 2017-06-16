package model;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/1/2017.
 * FileName : UserListConn.java.
 */
public class UserListConn {
  private ArrayList<String> userLists;
  private String keyword;
  private int minFollower;
  private int maxFollower;
  private int minRepoNum;

  private int maxRepoNum;

  private boolean repoNum;
  private boolean follower;

  public void setRepoNum(boolean repoNum) {
    this.repoNum = repoNum;
  }

  public void setFollower(boolean follower) {
    this.follower = follower;
  }

  public void setMinFollower(int minFollower) {
    this.minFollower = minFollower;
  }

  public void setMaxFollower(int maxFollower) {
    this.maxFollower = maxFollower;
  }

  public void setMinRepoNum(int minRepoNum) {
    this.minRepoNum = minRepoNum;
  }

  public void setMaxRepoNum(int maxRepoNum) {
    this.maxRepoNum = maxRepoNum;
  }


  /**
   * Konstruktor UserListConn.
   * Menginisialisasi ArrayList dan juga mengeset min serta max dari repoNum dan follower
   */
  public UserListConn() {
    userLists = new ArrayList<>();
    minRepoNum = 0;
    maxRepoNum = 100000;
    minFollower = 0;
    maxFollower = 1000000;
    keyword = "";
    repoNum = false;
    follower = false;
  }

  public ArrayList<String> getUserLists() {
    return userLists;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  /**
   * Fungsi search.
   * Melakukan request pada github dan memasukkan hasilnya ke dalam arraylist.
   * @param selection 0:username, 1:fullname, 2:email
   */
  public void search(int selection) throws IOException {
    // delete semua hasil terdahulu
    userLists.clear();
    StringBuilder urlLink = new StringBuilder("https://api.github.com/search/users?" + "q=");
    if (!keyword.equals("")) {
      urlLink.append(keyword).append("+");
    }
    if (selection == 0) {
      urlLink.append("in:login");
    } else if (selection == 1) {
      urlLink.append("in:fullname");
    } else {
      urlLink.append("in:email");
    }
    if (follower) {
      urlLink.append("+followers:\"").append(minFollower).append("%20..%20")
          .append(maxFollower).append("\"");
    }
    if (repoNum) {
      urlLink.append("+repos:\"").append(minRepoNum).append("%20..%20")
          .append(maxRepoNum).append("\"");
    }
    GetConn connection;
    connection = new GetConn(urlLink.toString());
    Gson gson = new Gson();
    SearchResults res = gson.fromJson(connection.getResponse().toString(),SearchResults.class);
    for (SearchResults.LoginName log : res.items) {
      userLists.add(log.login);
    }

  }

  private class SearchResults {
    LoginName[] items;

    private class LoginName {
      String login;

      public LoginName() {
      }
    }

    public SearchResults() {
    }
  }
}
