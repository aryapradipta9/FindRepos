package model;

import java.net.URL;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/3/2017.
 * FileName : Repo.java.
 */
public class Repo {
  private String name;
  private URL html_url;
  private String description;

  public Repo() {
  }

  public String getName() {
    return name;
  }

  public URL getHtml_url() {
    return html_url;
  }

  public String getDescription() {
    return description;
  }
}
