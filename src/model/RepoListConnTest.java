package model;

import org.junit.jupiter.api.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/18/2017.
 * FileName : RepoListConnTest.java.
 */

class RepoListConnTest {

  private RepoListConn repoListConn = new RepoListConn();

  @Test
  void getNumRepos() {
    assert repoListConn.getNumRepos() == 0;
  }

  @Test
  void setUsername() {
    repoListConn.setUsername("tom");
    assert repoListConn.getUsername().equals("tom");
  }

  @Test
  void getRepoList() {
  }

  @Test
  void search() {
  }



}