package com.github.canary;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExampleTest {
    WebDriver driver;

    @BeforeMethod
    public void setupDriver() {
        driver = Utils.getDriver();
    }

    @AfterMethod
    public void cleanupDriver() {
        driver.close();
    }

    @Test
    public void shouldGetHome() {
        driver.get("https://example.com");
        String title = driver.getTitle();

        Assert.assertEquals(title, "Example Domain");
    }
}
