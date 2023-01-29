package com.github.jasmaa.testngcanaryexample;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class DummyTest {
  @Test
  public void shouldAnswerWithTrue() {
    Assert.assertTrue(true);
  }

  @Test
  public void shouldFail() {
    Assert.fail("Fail this");
  }

  @Test
  public void shouldSkip() {
    throw new SkipException("Skip this");
  }
}
