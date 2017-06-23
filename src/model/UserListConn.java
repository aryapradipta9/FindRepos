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

  /**
   * Getter UserLists
   * @return ArrayList of string dari query yang dicari.
   */
  public ArrayList<String> getUserLists() {
    return userLists;
  }

  /**
   * Setter Keyword.
   * @param keyword mengeset keyword yang akan dicari
   */
  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  /**
   * Setter RepoNum.
   * @param repoNum apakah repoNum dienable
   */
  public void setRepoNum(boolean repoNum) {
    this.repoNum = repoNum;
  }

  /**
   * Setter Follower.
   * @param follower apakah follower dienable
   */
  public void setFollower(boolean follower) {
    this.follower = follower;
  }

  /**
   * Setter MinFollower.
   * @param minFollower integer minimal follower yang difilter
   */
  public void setMinFollower(int minFollower) {
    this.minFollower = minFollower;
  }

  /**
   * Setter MaxFollower.
   * @param maxFollower integer maksimal follower yang difilter
   */
  public void setMaxFollower(int maxFollower) {
    this.maxFollower = maxFollower;
  }

  /**
   * Setter MinRepoNum.
   * @param minRepoNum integer minimal repoNum yang difilter
   */
  public void setMinRepoNum(int minRepoNum) {
    this.minRepoNum = minRepoNum;
  }

  /**
   * Setter MaxRepoNum.
   * @param maxRepoNum integer maksimal repoNum yang difilter
   */
  public void setMaxRepoNum(int maxRepoNum) {
    this.maxRepoNum = maxRepoNum;
  }

  /**
   * Getter Keyword.
   * @return mengambil string keyword apa yang tersimpan
   */
  public String getKeyword() {
    return keyword;
  }

  /**
   * Getter MinFollower.
   * @return integer minimal follower yang difilter
   */
  public int getMinFollower() {
    return minFollower;
  }

  /**
   * Getter MaxFollower.
   * @return integer maksimal follower yang difilter
   */
  public int getMaxFollower() {
    return maxFollower;
  }

  /**
   * Getter MinRepoNum.
   * @return integer minimal repoNum yang difilter
   */
  public int getMinRepoNum() {
    return minRepoNum;
  }

  /**
   * Getter MaxRepoNum.
   * @return integer maksimal repoNum yang difilter
   */
  public int getMaxRepoNum() {
    return maxRepoNum;
  }

  /**
   * Fungsi IsRepoNum.
   * @return apakah repoNum dienable
   */
  public boolean isRepoNum() {
    return repoNum;
  }

  /**
   * Fungsi IsFollower.
   * @return apakah follower dienable
   */
  public boolean isFollower() {
    return follower;
  }

  /**
   * Fungsi search.
   * Melakukan request pada github dan memasukkan hasilnya ke dalam arraylist.
   * @param selection 0:username, 1:fullname, 2:email
   * @throws IOException jika internet tidak tersambung
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
