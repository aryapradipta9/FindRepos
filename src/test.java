import com.google.gson.Gson;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 5/21/2017.
 * FileName : test.java.
 */
public class test {


  public static void main(String[] args) {
    HttpURLConnection con = null;
    StringBuilder str = new StringBuilder();
    URL url = null;
    try {
      url = new URL("https://api.github.com/users/aryapradipta9/repos");
      con = (HttpURLConnection) url.openConnection();
      InputStream in = new BufferedInputStream(con.getInputStream());
      BufferedReader bfr = new BufferedReader(new InputStreamReader(in));
      String line;
      while ((line = bfr.readLine()) != null) {
        str.append(line);
      }

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      con.disconnect();
    }
    Gson gson = null;
    gson.fromJson(str.toString(),Temp.class);
    System.out.print(str);


  }

  private static class Temp {
    private String name;
    public Temp(){
      
    }
  }
}
