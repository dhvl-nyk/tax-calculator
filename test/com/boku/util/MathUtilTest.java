package com.boku.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MathUtilTest {

  @Test
  public void testRoundoff() {
    assertEquals(0.1, MathUtil.roundoff(0.5925, 0.05), 0.6);
  }

  @Test
  public void testTruncate() {
    assertEquals(0.0, MathUtil.truncate(0.1234), 0.12);
  }
}
