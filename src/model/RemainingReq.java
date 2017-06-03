package model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URL;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/3/2017.
 * FileName : RemainingReq.java.
 */
public class RemainingReq {
  private int repoReq;
  private int userReq;

  public RemainingReq() {
  }

  public int getRepoReq() {
    return repoReq;
  }

  public int getUserReq() {
    return userReq;
  }

  public void update() {
    GetConn connection = new GetConn("https://api.github.com/rate_limit");
    JsonParser parser = new JsonParser();
    JsonObject full = parser.parse(connection.getResponse().toString()).getAsJsonObject();
    JsonObject resource = full.getAsJsonObject("resources");
    repoReq = resource.getAsJsonObject("core").get("limit").getAsInt();
    userReq = resource.getAsJsonObject("search").get("limit").getAsInt();
  }

  public static void main(String[] args) {
    RemainingReq testing = new RemainingReq();
    testing.update();
    System.out.println(testing.getRepoReq());
    System.out.println(testing.getUserReq());
  }
}
