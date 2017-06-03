package model;

import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.util.ArrayList;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/1/2017.
 * FileName : UserListConn.java.
 */
public class UserListConn {
  private ArrayList<String> userLists;
  private String keyword;
  private String status;
  private HttpURLConnection con = null;
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


  public UserListConn() {
    userLists = new ArrayList<>();
    minRepoNum = 0;
    maxRepoNum = 100000;
    minFollower = 10000;
    maxFollower = 1000000;
    keyword = "";
    repoNum = false;
    follower = false;
  }

  public UserListConn(String keyword) {
    this.keyword = keyword;
    userLists = new ArrayList<>();
    minRepoNum = 0;
    maxRepoNum = 100000;
    minFollower = 0;
    maxFollower = 1000000;
    repoNum = false;
    follower = false;
  }

  public ArrayList<String> getUserLists() {
    return userLists;
  }

  // tambahin ke array
  public void addUsername(String str) {
    userLists.add(str);
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public void setUserLists(ArrayList<String> userLists) {
    this.userLists = userLists;
  }

  public void searchByUsername() {
    // delete semua hasil terdahulu
    userLists.clear();
    StringBuffer urlLink = new StringBuffer("https://api.github.com/search/users?" + "q=");
    if (!keyword.equals("")) {
      urlLink.append(keyword + "+");
    }
    urlLink.append("in:login");
    if (follower) {
      urlLink.append("+followers:\"" + minFollower + "%20..%20" + maxFollower + "\"");
    }
    System.out.println(urlLink.toString());
    GetConn connection = new GetConn(urlLink.toString());
    Gson gson = new Gson();
    SearchResults res = gson.fromJson(connection.getResponse().toString(),SearchResults.class);
    for (SearchResults.LoginName log : res.items) {
      userLists.add(log.login);
    }
  }

  public void searchByEmail() {
    // delete semua hasil terdahulu
    userLists.clear();
    String urlLink = "https://api.github.com/search/users?" + "q=" + keyword + "+in:email";
    GetConn connection = new GetConn(urlLink);
    Gson gson = new Gson();
    SearchResults res = gson.fromJson(connection.getResponse().toString(),SearchResults.class);
    for (SearchResults.LoginName log : res.items) {
      userLists.add(log.login);
    }
  }

  public static void main(String[] args) {
    UserListConn testing = new UserListConn();
    testing.setFollower(true);
    testing.setKeyword("torv");
    testing.searchByUsername();
    ArrayList<String> res = testing.getUserLists();
    for (String k : res) {
      System.out.println(k);
    }
  }
  private class SearchResults {
    public int total_count;
    LoginName[] items;

    private class LoginName {
      public String login;

      public LoginName() {
      }
    }

    public SearchResults() {
    }
  }
}
