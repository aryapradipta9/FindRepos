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

  /**
   * Konstruktor tanpa parameter.
   */
  public Repo() {
  }

  /**
   * Konstruktor dengan parameter.
   * @param name nama dari repo tersebut
   * @param html_url alamat url dari repo
   * @param description deskripsi repo
   */
  public Repo(String name, URL html_url, String description) {
    this.name = name;
    this.html_url = html_url;
    this.description = description;
  }

  /**
   * Getter Name.
   * @return string nama repo tersebut
   */
  public String getName() {
    return name;
  }

  /**
   * Getter URL.
   * @return URL repo tersebut
   */
  public URL getHtml_url() {
    return html_url;
  }

  /**
   * Getter Description.
   * @return string deskripsi dari url tersebut
   */
  public String getDescription() {
    return description;
  }
}
