package model;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/18/2017.
 * FileName : RemainingReqTest.java.
 */
class RemainingReqTest {
  @Test
  void update() throws IOException {
    RemainingReq remainingReq = new RemainingReq();
    remainingReq.update();
    assert remainingReq.getRepoReq() <= 60;
    assert remainingReq.getUserReq() <= 10;
  }

}