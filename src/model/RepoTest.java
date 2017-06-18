package model;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/16/2017.
 * FileName : RepoTest.java.
 */
class RepoTest {
  private Repo repo = new Repo("repotest",new URL("https://api.github.com"),"testing repo");

  RepoTest() throws MalformedURLException {
  }

  @org.junit.jupiter.api.Test
  void getName() {
    assert (repo.getName().equals("repotest"));

  }

  @org.junit.jupiter.api.Test
  void getHtml_url() throws MalformedURLException {
    URL testUrl = null;
      testUrl = new URL("https://api.github.com");
      assert (repo.getHtml_url().equals(testUrl));

  }

  @org.junit.jupiter.api.Test
  void getDescription() {
    assert (repo.getDescription().equals("testing repo"));
  }

}