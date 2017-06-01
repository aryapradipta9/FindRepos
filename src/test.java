import com.google.gson.Gson;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import org.apache.http.client.methods.HttpGet;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 5/21/2017.
 * FileName : test.java.
 */
public class test {


  public static void main(String[] args) {
    HttpGet temp;

    HttpURLConnection con = null;
    StringBuilder str = new StringBuilder();
    URL url = null;
    try {
      url = new URL("https://api.github.com/users/aryapradipta9/repos");
      con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      Map<String, List<String>> map = con.getHeaderFields();

      System.out.println("Printing Response Header...\n");

      for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        System.out.println("Key : " + entry.getKey()
            + " ,Value : " + entry.getValue());
      }

      System.out.println("\nGet Response Header By Key ...\n");
      String server = con.getHeaderField("Server");

      if (server == null) {
        System.out.println("Key 'Server' is not found!");
      } else {
        System.out.println("Server - " + server);
      }

      System.out.println("\n Done");

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
    //Temp[] ints2 = gson.fromJson("[{\"name\":\"WAWA\",\"urls\":\"http://code.google.com/p/google-gson/\",\"Inner\": {\"in\":5}},{\"name\":\"WAWAK\",\"urls\":\"http://code.google.com/p/google-gson/\",\"Inner\": {\"in\":4}}]", Temp[].class);
    Temp[] ints2 = gson.fromJson(str.toString(),Temp[].class);
    System.out.print(ints2[0].name);


  }

  private static class Temp {
    public String name;

    //public inclass Inner;
    public static class inclass {
      public int in;
      public inclass() {
      }
    }
    public Temp(){
      
    }
  }
}
