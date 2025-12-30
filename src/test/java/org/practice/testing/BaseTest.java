package org.practice.testing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

  protected static WebDriver driver;
  protected static final Properties prop = new Properties();
  protected static final Logger logger = LogManager.getLogger(BaseTest.class);

  static {
      String resourceName = "config.properties";
      try(InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName)) {
          if (inputStream==null) {
              InputStream inputStream1 = BaseTest.class.getResourceAsStream("/"+resourceName);
              if (inputStream1 == null) {
                  throw new IllegalStateException("could not find the resource" + resourceName);
              } else {
                  prop.load(inputStream1);
              }
          } else {
              prop.load(inputStream);
          }
      } catch (Exception e) {
          logger.error(e.getMessage());
      }
  }
  public WebDriver getDriver(){
      return driver;
  }

  @BeforeSuite()
  @Parameters({"browser","os","type"})
  public void setUp(String br, String os, String hosType) throws Exception {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      if (hosType.equals("remote")) {
       URL gridURL = new URL(prop.getProperty("LOCALHOST"));
          switch (br.toLowerCase()) {
          case "chrome":
              capabilities.setBrowserName("chrome");
              break;
          case "firefox":
              capabilities.setBrowserName("firefox");
              break;
            }
      driver = new RemoteWebDriver(gridURL,capabilities);
     }  else if (hosType.equals("local")){
          driver = new ChromeDriver();
      }

      driver.manage().deleteAllCookies();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get(prop.getProperty("URL"));
      driver.manage().window().maximize();
     }


     @AfterSuite(alwaysRun = true)
     public void tearDown() {
      if (driver!=null) {
          driver.quit();
       }
     }
 }
