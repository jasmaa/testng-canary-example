package com.github.canary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
  public static WebDriver getDriver() {
    WebDriver driver = new ChromeDriver();
    return driver;
  }
}
