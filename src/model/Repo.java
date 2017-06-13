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

  public void setName(String name) {
    this.name = name;
  }

  public void setHtml_url(URL html_url) {
    this.html_url = html_url;
  }

  public void setDescription(String description) {
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
