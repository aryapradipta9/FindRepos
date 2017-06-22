package model;

import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/17/2017.
 * FileName : UserListConnTest.java.
 */

@PrepareForTest(value = UserListConn.class)
class UserListConnTest {

  private UserListConn userListConn = new UserListConn();

  @Test
  void setRepoNum() {
    userListConn.setRepoNum(true);
    assert userListConn.isRepoNum();
  }

  @Test
  void setFollower() {
    userListConn.setFollower(true);
    assert userListConn.isFollower();
  }

  @Test
  void setMinFollower() {
    userListConn.setMinFollower(1);
    assert userListConn.getMinFollower() == 1;
  }

  @Test
  void setMaxFollower() {
    userListConn.setMaxFollower(10);
    assert userListConn.getMaxFollower() == 10;
  }

  @Test
  void setMinRepoNum() {
    userListConn.setMinRepoNum(1);
    assert userListConn.getMinRepoNum() == 1;
  }

  @Test
  void setMaxRepoNum() {
    userListConn.setMaxRepoNum(10);
    assert userListConn.getMaxRepoNum() == 10;
  }

  @Test
  void setKeyword() {
    userListConn.setKeyword("tom");
    assert userListConn.getKeyword().equals("tom");
  }

  @Test
  void search() throws Exception {
    UserListConn uuserListConn = new UserListConn();
    GetConn getConn = PowerMockito.mock(GetConn.class);
    StringBuilder stringBuilder = new StringBuilder("{\"total_count\": 46045,\"incomplete_results\": false,\"items\": [{\"login\": \"tom\",\"id\": 748,\"avatar_url\": \"https://avatars2.githubusercontent.com/u/748?v=3\",\"gravatar_id\": \"\",\"url\": \"https://api.github.com/users/tom\",\"html_url\": \"https://github.com/tom\",\"followers_url\": \"https://api.github.com/users/tom/followers\",\"following_url\": \"https://api.github.com/users/tom/following{/other_user}\",\"gists_url\": \"https://api.github.com/users/tom/gists{/gist_id}\",\"starred_url\": \"https://api.github.com/users/tom/starred{/owner}{/repo}\",\"subscriptions_url\": \"https://api.github.com/users/tom/subscriptions\",\"organizations_url\": \"https://api.github.com/users/tom/orgs\",\"repos_url\": \"https://api.github.com/users/tom/repos\",\"events_url\": \"https://api.github.com/users/tom/events{/privacy}\",\"received_events_url\": \"https://api.github.com/users/tom/received_events\",\"type\": \"User\",\"site_admin\": false,\"score\": 70.879166}]}");
    PowerMockito.when(getConn.getResponse()).thenReturn(stringBuilder);
    String tom = "https://api.github.com/search/users?q=tom+in:login";
    PowerMockito.whenNew(GetConn.class).withAnyArguments().thenReturn(getConn);
    //PowerMockito.whenNew(GetConn.class).withArguments(tom).thenReturn(getConn);
    uuserListConn.setKeyword("tom");
    uuserListConn.setRepoNum(false);
    uuserListConn.setFollower(false);
    uuserListConn.search(0);
  }

}