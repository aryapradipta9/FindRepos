package model;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
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

  public UserListConn(String keyword) {
    this.keyword = keyword;
    userLists = new ArrayList<>();
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
    //userLists.clear();
    String urlLink = "https://api.github.com/search/users?" + "q=" + keyword + "+in:login";
    StringBuilder str = new StringBuilder();
    try {
      URL url = new URL(urlLink);
      con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      InputStream in = new BufferedInputStream(con.getInputStream());
      BufferedReader bfr = new BufferedReader(new InputStreamReader(in));
      String line;
      while ((line = bfr.readLine()) != null) {
        str.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      con.disconnect();
    }
    Gson gson = new Gson();
    SearchResults res = gson.fromJson(str.toString(),SearchResults.class);
    for (SearchResults.LoginName log : res.items) {
      userLists.add(log.login);
    }

  }

  public static void main(String[] args) {
    UserListConn testing = new UserListConn("aryapradipta");
    testing.searchByUsername();
    ArrayList<String> res = testing.getUserLists();
    for (String k : res) {
      System.out.println(k);
    }
  }
  private class SearchResults {
    public int total_count;
    public LoginName[] items;

    private class LoginName {
      public String login;

      public LoginName() {
      }
    }

    public SearchResults() {
    }
  }
}
