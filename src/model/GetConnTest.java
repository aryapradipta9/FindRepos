package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/17/2017.
 * FileName : GetConnTest.java.
 */
class GetConnTest {

  @BeforeEach
  void setUp() {
  }

  @Test
  void getResponse() throws Exception {
    //URL mockUrl = PowerMockito.mock(URL.class);
    //String url = "https://api.github.com";
    //PowerMockito.whenNew(URL.class).withArguments(url).thenReturn(mockUrl);
    GetConn getConn = PowerMockito.mock(GetConn.class);
    StringBuilder stringBuilder = new StringBuilder("testing");
    PowerMockito.when(getConn.getResponse()).thenReturn(stringBuilder);
    assert (getConn.getResponse().equals(stringBuilder));

  }

}