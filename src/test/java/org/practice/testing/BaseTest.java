package org.practice.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

 // private static WebDriver webDriver;
  private static final Properties props = new Properties();
  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    static {
      String resourceName = "application.properties";
      try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName)) {

          if (inputStream == null) {
                InputStream inputStream2 = BaseTest.class.getResourceAsStream("/"+ resourceName);
                if (inputStream2 == null) {
                    throw new IllegalStateException("Could not find " + resourceName + " on the classpath. Make sure it's in src/main/resources or src/test/resources.");
                } else {
                    props.load(inputStream2);
                }
          } else {
              props.load(inputStream);
          }
      }  catch (Exception e) {
          throw new RuntimeException("Failed to load"+resourceName, e);
      }
  }

  public WebDriver getDriver(){
      return driver.get();
  }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "os"})
    public void setUp(String browser, String os) throws Exception {

        WebDriver webDriver;

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setPlatformName(os);
            webDriver = new RemoteWebDriver(new URL(props.getProperty("GRID_URL")), options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.setPlatformName(os);
            webDriver = new RemoteWebDriver(new URL(props.getProperty("GRID_URL")), options);

        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.setPlatformName(os);
            webDriver = new RemoteWebDriver(new URL(props.getProperty("GRID_URL")), options);

        } else {
            throw new Exception("Unsupported browser: " + browser);
        }

        driver.set(webDriver);

        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(props.getProperty("URL"));
        getDriver().manage().window().maximize();
    }

     @AfterMethod (alwaysRun = true)
      public void tearDown() {
          if (getDriver()!=null) {
              getDriver().quit();
              driver.remove();
          }
     }
  }
