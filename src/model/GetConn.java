package model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/1/2017.
 * FileName : GetConn.java.
 */
public class GetConn {
  private StringBuilder response;

  /**
   * Konstruktor GetConn.
   * @param link URL yang akan disambungkan dan dibaca responsnya
   * @throws IOException Jika string bukan url ataupun tidak terkoneksi dengan internet
   */
  public GetConn(String link) throws IOException {
    response = new StringBuilder();
    URL url = new URL(link);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    InputStream in = new BufferedInputStream(con.getInputStream());
    BufferedReader bfr = new BufferedReader(new InputStreamReader(in));
    String line;
    while ((line = bfr.readLine()) != null) {
      response.append(line);
    }
    con.disconnect();
  }

  /**
   * Getter Response.
   * @return Stringbuilder hasil dari respons yang diberikan link
   */
  public StringBuilder getResponse() {
    return response;
  }
}
