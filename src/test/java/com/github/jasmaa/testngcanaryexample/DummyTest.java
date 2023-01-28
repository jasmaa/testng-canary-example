package com.github.jasmaa.testngcanaryexample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DummyTest implements CloudWatchMetricTest {
  @Test
  public void shouldAnswerWithTrue() {
    Assert.assertTrue(true);
  }
}
