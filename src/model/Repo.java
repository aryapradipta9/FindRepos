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

  public Repo(String name, URL html_url, String description) {
    this.name = name;
    this.html_url = html_url;
    this.description = description;
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
