package model;

import org.junit.jupiter.api.Test;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/18/2017.
 * FileName : RemainingReqTest.java.
 */
class RemainingReqTest {
  @Test
  void update() throws java.io.IOException {
    RemainingReq remainingReq = new RemainingReq();
    remainingReq.update();
    assert remainingReq.getRepoReq() <= 60;
    assert remainingReq.getUserReq() <= 10;
  }

}