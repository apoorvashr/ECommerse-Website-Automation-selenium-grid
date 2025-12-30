package org.practice.testing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.practice.DashboardPage;
import org.practice.LoginPage;
import org.practice.MyAccountPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

private static final Logger logger = LogManager.getLogger(LoginTest.class);
  DashboardPage dashboardPage;
  LoginPage loginPage;
 // MyAccountPage myAccountPage;

   @Test()
   public void verifyLoginNav() {
     logger.info("navigate to login page");
     dashboardPage = new DashboardPage(this.getDriver());
     dashboardPage.navTologin();
   }

    @Test(dependsOnMethods = "verifyLoginNav")
    public void verifyAccountLoggedIn(){
        // myAccountPage = new MyAccountPage(this.getDriver());
        // myAccountPage.verifyLoggedin();
        loginPage = new LoginPage(driver);
        loginPage.loginUser();
    }
    /*@Test(dependsOnMethods = "verifyAccountLoggedIn")
    public void verifyAccount(){
        myAccountPage = new MyAccountPage(this.getDriver());
        myAccountPage.verifyLoggedin();
    }*/
}
