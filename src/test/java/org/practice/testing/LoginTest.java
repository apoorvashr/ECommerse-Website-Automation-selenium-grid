package org.practice.testing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.practice.DashboardPage;
import org.practice.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

private static final Logger logger = LogManager.getLogger(LoginTest.class);
  DashboardPage dashboardPage;
  LoginPage loginPage;

   @Test()
   public void verifyLogin() {
     logger.info("navigate to login page");
     dashboardPage = new DashboardPage(getDriver());
       dashboardPage.navTologin();
    /* loginPage = new LoginPage(driver);
    */

   }



}
