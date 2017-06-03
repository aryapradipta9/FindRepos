package model;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/1/2017.
 * FileName : GetConn.java.
 */
public class GetConn {
  private String link;
  private StringBuilder response;

  public GetConn(String link) {
    this.link = link;
    response = new StringBuilder();
    HttpURLConnection con = null;
    try {
      URL url = new URL(link);
      con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      InputStream in = new BufferedInputStream(con.getInputStream());
      BufferedReader bfr = new BufferedReader(new InputStreamReader(in));
      String line;
      while ((line = bfr.readLine()) != null) {
        response.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      con.disconnect();
    }

  }

  public String getLink() {
    return link;
  }

  public StringBuilder getResponse() {
    return response;
  }
}
